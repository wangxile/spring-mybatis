package com.wangxile.springmybatis.beandefinitionregistrar;

import com.wangxile.springmybatis.dao.CityDAO;
import com.wangxile.springmybatis.dao.StudentDAO;
import com.wangxile.springmybatis.factorybean.XileFactoryBean;
import com.wangxile.springmybatis.invocationhandler.XileInvocationHandler;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.reflect.Proxy;

/**
 * @Author:wangqi
 * @Description:
 * @Date:Created in 2019/7/13
 * @Modified by: 可以往beanDefinitionMap中添加beanDefinition
 */
public class XileBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        //模拟mapperScan扫描,获取所有DAO类信息
        Class[] clazzs = new Class[]{CityDAO.class,StudentDAO.class};
        for (Class clazz : clazzs) {
            //传入class就能够生成对应的BeanDefinition
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
            AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

            //获取老的类名，因为下面要替换成XileFactoryBean，所以提前获取
            String oldBeanName = beanDefinition.getBeanClass().getSimpleName();
            beanDefinition.setBeanClass(XileFactoryBean.class);

            //通过操作beanDefinition, 实际上是操作XileFactoryBean, 调用XileFactoryBean带参构造方法,将class传入实现动态
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(clazz);
            //注册beanDefinition,到map中
            beanDefinitionRegistry.registerBeanDefinition(oldBeanName, beanDefinition);
        }


        //生成代理对象  因为代理对象是运行时生成的并没有class类，无法使用这时候就要用到FactoryBean
//        XileInvocationHandler xileInvocationHandlere = new XileInvocationHandler();
//        CityDAO cityDAO = (CityDAO)Proxy.newProxyInstance(this.getClass().getClassLoader(),CityDAO.class.getInterfaces(),xileInvocationHandlere);
//        cityDAO.query();


    }
}
