package com.wangxile.springmybatis.dao;

import org.aspectj.lang.annotation.Before;

/**
 * @Author:wangqi
 * @Description:
 * @Date:Created in 2019/7/13
 * @Modified by:
 */
public interface StudentDAO {
    @Before("StudentDAO")
    void query();
}
