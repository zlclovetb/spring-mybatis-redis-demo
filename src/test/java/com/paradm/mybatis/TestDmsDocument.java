package com.paradm.mybatis;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.paradm.mybatis.dao.DmsDocumentMapper;
import com.paradm.mybatis.entity.DmsDocument;
import com.paradm.mybatis.entity.DmsDocumentExample;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/applicationContext.xml"})
public class TestDmsDocument {
  @Autowired
  protected SqlSessionFactory sessionFactory;
  
  @Test
  @Transactional(propagation = Propagation.NOT_SUPPORTED)
  public void getdoc() {
    SqlSession session = sessionFactory.openSession();
    DmsDocumentMapper docMapper = session.getMapper(DmsDocumentMapper.class);
    DmsDocument dmsDocument = docMapper.selectByPrimaryKey(1059974730427138195l);
    DmsDocument dmsDocument2 = docMapper.selectByDocName(1059387103026086129l, "PHK_IssueList_20151118.xlsx");
    System.out.println(dmsDocument.getDocName());
    System.out.println(dmsDocument2.getId());
    session.close();
    
    session = sessionFactory.openSession();
    docMapper = session.getMapper(DmsDocumentMapper.class);
    DmsDocument dmsDocument3 = docMapper.selectByPrimaryKey(1059974730427138195l);
    DmsDocument dmsDocument4 = docMapper.selectByDocName(1059387103026086129l, "PHK_IssueList_20151118.xlsx");
    System.out.println(dmsDocument3.getId());
    System.out.println(dmsDocument4.getId());
    session.close();
  }
  
  @Test
  public void getPageDoc() {
    SqlSession session = sessionFactory.openSession();
    DmsDocumentMapper docMapper = session.getMapper(DmsDocumentMapper.class);
    
    DmsDocumentExample example = new DmsDocumentExample();
    example.createCriteria().andParentIdEqualTo(1059387103026086129l).andRootIdEqualTo(1059387103026086122l)
    .andRecordStatusEqualTo("A");
    example.setOrderByClause("'DOC_TYPE' DESC, 'DOC_NAME' ASC");
    PageHelper.startPage(2, 10);
    List<DmsDocument> list = docMapper.selectByExample(example);
    System.out.println(list.size());
  }
  
  @Test
  public void getPageDocRowbounds() {
    SqlSession session = sessionFactory.openSession();
    DmsDocumentMapper docMapper = session.getMapper(DmsDocumentMapper.class);
    
    DmsDocumentExample example = new DmsDocumentExample();
    example.createCriteria().andParentIdEqualTo(1059387103026086129l).andRootIdEqualTo(1059387103026086122l)
    .andRecordStatusEqualTo("A");
    
    List<DmsDocument> list = docMapper.selectByExampleWithRowbounds(example, new RowBounds(0, 10));
    System.out.println(list.size());
  }
   
  @SuppressWarnings("rawtypes")
  @Test
  public void getPageDocFilterPermission() {
    SqlSession session = sessionFactory.openSession();
    DmsDocumentMapper docMapper = session.getMapper(DmsDocumentMapper.class);
    Sort sort = null;
    //sort = Sort.by(Direction.valueOf("ASC"), "DOC_NAME");
    
    PageHelper.startPage(2, 10);
    Page<LinkedHashMap> list = (Page<LinkedHashMap>) docMapper.selectByExampleFilterPermission(1059387103026086129l, 1059387103026086122l, 1059387103026086110l, sort);
    List<LinkedHashMap> result = list.getResult();
    List objectList = result.stream().map(link -> {
      return link.values().toArray();
    }).collect(Collectors.toList());
    
    System.out.println(objectList.size());
  }
}
