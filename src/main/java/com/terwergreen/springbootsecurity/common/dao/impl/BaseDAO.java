package com.terwergreen.springbootsecurity.common.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;

/**
 * @Author Terwer
 * @Date 2018/6/25 12:15
 * @Version 1.0
 * @Description TODO
 **/
public class BaseDAO extends SqlSessionDaoSupport {
    protected final Log logger = LogFactory.getLog(this.getClass());

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

}
