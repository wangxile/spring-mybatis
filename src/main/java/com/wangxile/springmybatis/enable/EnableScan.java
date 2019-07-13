package com.wangxile.springmybatis.enable;

import com.wangxile.springmybatis.beandefinitionregistrar.XileBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author:wangqi
 * @Description:
 * @Date:Created in 2019/7/13
 * @Modified by:
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(XileBeanDefinitionRegistrar.class)
public @interface EnableScan {

}
