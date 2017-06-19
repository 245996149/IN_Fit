package cn.infit.ll.dao;

import cn.infit.ll.dbentity.UserDataEntity;

/**
 * Created by kaxia on 2017/6/16.
 */
public interface UserDataDao {

    UserDataEntity findByUser_idOrderCreate_time(Long user_id);

}
