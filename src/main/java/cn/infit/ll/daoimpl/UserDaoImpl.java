package cn.infit.ll.daoimpl;

import cn.infit.ll.dao.SuperDao;
import cn.infit.ll.dao.UserDao;
import cn.infit.ll.dbentity.UsersEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by kaxia on 2017/6/15.
 */
@Repository
public class UserDaoImpl extends SuperDao implements UserDao {


    @Override
    public UsersEntity findByUser_phone(String user_phone) {

        try (Session session = sessionFactory.openSession()) {

            Query query = session.createQuery("from UsersEntity where userPhone = ?");

            query.setParameter(0, user_phone);

            return (UsersEntity) query.uniqueResult();

        }

    }

}
