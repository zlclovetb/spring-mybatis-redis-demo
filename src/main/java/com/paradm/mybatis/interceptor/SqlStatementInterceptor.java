package com.paradm.mybatis.interceptor;

import java.lang.reflect.Field;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.defaults.DefaultSqlSession.StrictMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts(
    {@Signature(type = StatementHandler.class, method = "query", args = {Statement.class, ResultHandler.class}),
    @Signature(type = StatementHandler.class, method = "update", args = {Statement.class}), 
    @Signature(type = StatementHandler.class, method = "batch", args = {Statement.class})
})
public class SqlStatementInterceptor implements Interceptor {
  private static final Logger logger = LoggerFactory.getLogger(SqlStatementInterceptor.class);
  
  private Properties properties;

  public Object intercept(Invocation invocation) throws Throwable {
    long startTime = System.currentTimeMillis();
    try {
      return invocation.proceed();
    } finally {
      if (properties.get("timeout") != null) {
        long endTime = System.currentTimeMillis();
        long sqlCost = endTime - startTime;
        
        long timeout = Long.valueOf((String)properties.get("timeout"));
        if (sqlCost >= timeout) {
          StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
          BoundSql boundSql = statementHandler.getBoundSql();
          String sql = boundSql.getSql();
          Object parameterObject = boundSql.getParameterObject();
          List<ParameterMapping> parameterMappingList = boundSql.getParameterMappings();

          sql = formatSql(sql, parameterObject, parameterMappingList);

          String logStr = String.format("\nExecute SQL Cost [%dms]===> \n%s\n", sqlCost, sql);
          logger.info(logStr);
        }
      }
    }
  }

  public Object plugin(Object target) {
    return Plugin.wrap(target, this);
  }

  public void setProperties(Properties properties) {
    this.properties = properties;
  }

  private String formatSql(String sql, Object parameterObject, List<ParameterMapping> parameterMappingList) {
    if (sql == null || sql.length() == 0) {
      return "";
    }
    sql = beautifySql(sql);
    if (parameterObject == null || parameterMappingList == null || parameterMappingList.size() == 0) {
      return sql;
    }

    String sqlWithoutReplacePlaceholder = sql;

    try {
      if (parameterMappingList != null) {
        Class<?> parameterObjectClass = parameterObject.getClass();
        if (isStrictMap(parameterObjectClass)) {
          @SuppressWarnings("unchecked")
          StrictMap<Collection<?>> strictMap = (StrictMap<Collection<?>>) parameterObject;

          if (isList(strictMap.get("list").getClass())) {
            sql = handleListParameter(sql, strictMap.get("list"));
          }
        } else if (isMap(parameterObjectClass)) {
          Map<?, ?> paramMap = (Map<?, ?>) parameterObject;
          sql = handleMapParameter(sql, paramMap, parameterMappingList);
        } else {
          sql = handleCommonParameter(sql, parameterMappingList, parameterObjectClass, parameterObject);
        }
      }
    } catch (Exception e) {
      return sqlWithoutReplacePlaceholder;
    }

    return sql;
  }

  private String beautifySql(String sql) {
    // sql = sql.replace("\n", "").replace("\t", "").replace(" ", " ").replace("( ", "(").replace("
    // )", ")").replace(" ,", ",");
    sql = sql.replaceAll("[\\s\n ]+", " ");
    return sql;
  }

  private String handleListParameter(String sql, Collection<?> col) {
    if (col != null && col.size() != 0) {
      for (Object obj : col) {
        String value = null;
        Class<?> objClass = obj.getClass();
        if (isPrimitiveOrPrimitiveWrapper(objClass)) {
          value = obj.toString();
        } else if (objClass.isAssignableFrom(String.class)) {
          value = "\"" + obj.toString() + "\"";
        }

        sql = sql.replaceFirst("\\?", value);
      }
    }

    return sql;
  }

  private String handleMapParameter(String sql, Map<?, ?> paramMap, List<ParameterMapping> parameterMappingList) {
    for (ParameterMapping parameterMapping : parameterMappingList) {
      Object propertyName = parameterMapping.getProperty();
      Object propertyValue = paramMap.get(propertyName);
      if (propertyValue != null) {
        if (propertyValue.getClass().isAssignableFrom(String.class)) {
          propertyValue = "\"" + propertyValue + "\"";
        }

        sql = sql.replaceFirst("\\?", propertyValue.toString());
      }
    }

    return sql;
  }

  private String handleCommonParameter(String sql, List<ParameterMapping> parameterMappingList, Class<?> parameterObjectClass, Object parameterObject) throws Exception {
    for (ParameterMapping parameterMapping : parameterMappingList) {
      String propertyValue = null;
      if (isPrimitiveOrPrimitiveWrapper(parameterObjectClass)) {
        propertyValue = parameterObject.toString();
      } else {
        String propertyName = parameterMapping.getProperty();

        if(parameterObjectClass == String.class) {
          propertyValue = String.valueOf(parameterObject);
        }else {
          Field field = parameterObjectClass.getDeclaredField(propertyName);
          field.setAccessible(true);
          propertyValue = String.valueOf(field.get(parameterObject));
        }
        if (parameterMapping.getJavaType().isAssignableFrom(String.class)) {
          propertyValue = "\'" + propertyValue + "\'";
        }
      }

      sql = sql.replaceFirst("\\?", propertyValue);
    }

    return sql;
  }

  private boolean isPrimitiveOrPrimitiveWrapper(Class<?> parameterObjectClass) {
    return parameterObjectClass.isPrimitive() || (parameterObjectClass.isAssignableFrom(Byte.class) || parameterObjectClass.isAssignableFrom(Short.class)
        || parameterObjectClass.isAssignableFrom(Integer.class) || parameterObjectClass.isAssignableFrom(Long.class) || parameterObjectClass.isAssignableFrom(Double.class)
        || parameterObjectClass.isAssignableFrom(Float.class) || parameterObjectClass.isAssignableFrom(Character.class) || parameterObjectClass.isAssignableFrom(Boolean.class));
  }

  private boolean isStrictMap(Class<?> parameterObjectClass) {
    return parameterObjectClass.isAssignableFrom(StrictMap.class);
  }

  private boolean isList(Class<?> clazz) {
    Class<?>[] interfaceClasses = clazz.getInterfaces();
    for (Class<?> interfaceClass : interfaceClasses) {
      if (interfaceClass.isAssignableFrom(List.class)) {
        return true;
      }
    }

    return false;
  }

  private boolean isMap(Class<?> parameterObjectClass) {
    Class<?>[] interfaceClasses = parameterObjectClass.getInterfaces();
    for (Class<?> interfaceClass : interfaceClasses) {
      if (interfaceClass.isAssignableFrom(Map.class)) {
        return true;
      }
    }
    return false;
  }

}
