package com.wangxile.springmybatis.factorybean;

import com.wangxile.springmybatis.dao.CityDAO;
import com.wangxile.springmybatis.invocationhandler.XileInvocationHandler;
import com.wangxile.springmybatis.service.CityService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * @Author:wangqi
 * @Description:
 * @Date:Created in 2019/7/13
 * @Modified by:
 */
@Component
public class XileFactoryBean implements FactoryBean {

    //动态传入
    Class mapperInterface;

    public XileFactoryBean(){
    }

    public XileFactoryBean(Class mapperInterface){
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object getObject() throws Exception {
        XileInvocationHandler xileInvocationHandlere = new XileInvocationHandler();
        // CityDAO.class.getInterfaces();  纯粹的接口是无法用这种方式获取的  会报ClassCastException
        Class[] clazzs = new Class[]{mapperInterface};
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), clazzs, xileInvocationHandlere);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
