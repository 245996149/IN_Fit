package cn.infit.ll.dao;

import cn.infit.ll.dbentity.UsersEntity;

/**
 * Created by kaxia on 2017/6/15.
 */
public interface UserDao {

    UsersEntity findByUser_phone(String user_phone);

    UsersEntity findByOpen_id(String open_id);


}
