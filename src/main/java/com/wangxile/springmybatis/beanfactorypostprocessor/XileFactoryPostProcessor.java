package com.wangxile.springmybatis.beanfactorypostprocessor;

import com.wangxile.springmybatis.service.CityServiceImplCopy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Author:wangqi
 * @Description:
 * @Date:Created in 2019/7/13
 * @Modified by: 主要用来修改beanDefinition 无法进行添加
 */
@Component
public class XileFactoryPostProcessor  implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        //这时候spring已经将类都解析完成了，定义为了BeanDefintion,但是还没有放到DefintionMap中，我们可以进行干预
        GenericBeanDefinition cityService = (GenericBeanDefinition)configurableListableBeanFactory.getBeanDefinition("cityServiceImpl");
        cityService.setBeanClass(CityServiceImplCopy.class);
    }
}
