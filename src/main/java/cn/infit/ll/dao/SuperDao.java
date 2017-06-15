package cn.infit.ll.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by kaxia on 2017/6/15.
 */
@Component
public class SuperDao {

    @Resource
    public SessionFactory sessionFactory;

}
