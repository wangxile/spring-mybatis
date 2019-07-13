package com.wangxile.springmybatis.test;

import com.wangxile.springmybatis.config.AppConfig;
import com.wangxile.springmybatis.dao.CityDAO;
import com.wangxile.springmybatis.dao.StudentDAO;
import com.wangxile.springmybatis.factorybean.XileFactoryBean;
import com.wangxile.springmybatis.service.CityService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author:wangqi
 * @Description:
 * @Date:Created in 2019/7/13
 * @Modified by:
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        //这里只能用name获取才有代理springBean   用class获取得到的是原生类xileFactoryBean
        //System.out.println(annotationConfigApplicationContext.getBean("xileFactoryBean"));
        //System.out.println(annotationConfigApplicationContext.getBean("&xileFactoryBean"));

        //System.out.println(annotationConfigApplicationContext.getBean("cityServiceImpl"));
        CityDAO cityDAO = (CityDAO)annotationConfigApplicationContext.getBean("CityDAO");
        StudentDAO studentDAO = (StudentDAO)annotationConfigApplicationContext.getBean("StudentDAO");
        cityDAO.query();
        studentDAO.query();

    }
}
