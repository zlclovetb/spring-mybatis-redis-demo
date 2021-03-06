package com.paradm.mybatis.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;

import com.paradm.mybatis.entity.DmsDocument;
import com.paradm.mybatis.entity.DmsDocumentExample;

public interface DmsDocumentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DMS_DOCUMENT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DMS_DOCUMENT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    int insert(DmsDocument record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DMS_DOCUMENT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    int insertSelective(DmsDocument record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DMS_DOCUMENT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    List<DmsDocument> selectByExampleWithRowbounds(DmsDocumentExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DMS_DOCUMENT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    List<DmsDocument> selectByExample(DmsDocumentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DMS_DOCUMENT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    @Cacheable
    DmsDocument selectByPrimaryKey(Long id);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DMS_DOCUMENT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    DmsDocument selectByDocName(@Param("parentID")Long parentID, @Param("docName")String docName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DMS_DOCUMENT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    int updateByPrimaryKeySelective(DmsDocument record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DMS_DOCUMENT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    int updateByPrimaryKey(DmsDocument record);
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table DMS_DOCUMENT
     *
     * @mbg.generated Fri Nov 23 17:22:29 CST 2018
     */
    @SuppressWarnings("rawtypes")
    List<LinkedHashMap> selectByExampleFilterPermission(@Param("parentID")Long parentID, @Param("rootID")Long rootID, @Param("orgID")Long orgID, @Param("sort")Sort sort);
}