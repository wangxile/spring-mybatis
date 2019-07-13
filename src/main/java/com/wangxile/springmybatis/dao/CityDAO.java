package com.wangxile.springmybatis.dao;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author:wangqi
 * @Description:
 * @Date:Created in 2019/7/13
 * @Modified by:
 */
public interface CityDAO {
    @Before("CityDAO")
    void query();
}
