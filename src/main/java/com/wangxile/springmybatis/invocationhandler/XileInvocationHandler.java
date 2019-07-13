package com.wangxile.springmybatis.invocationhandler;

import org.aspectj.lang.annotation.Before;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author:wangqi
 * @Description:
 * @Date:Created in 2019/7/12
 * @Modified by:
 */
public class XileInvocationHandler implements InvocationHandler {

    //public Object target;

//    public XileInvocationHandler(Object target){
//        this.target = target;
//    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String msg = method.getDeclaredAnnotation(Before.class).value();
        System.out.println(msg);
        return null;
    }
}
