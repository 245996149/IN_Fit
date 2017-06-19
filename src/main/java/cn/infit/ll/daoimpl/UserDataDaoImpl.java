package cn.infit.ll.daoimpl;

import cn.infit.ll.dao.SuperDao;
import cn.infit.ll.dao.UserDataDao;
import cn.infit.ll.dbentity.UserDataEntity;
import cn.infit.ll.dbentity.UsersEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by kaxia on 2017/6/16.
 */
@Repository
public class UserDataDaoImpl extends SuperDao implements UserDataDao {

    @Override
    public UserDataEntity findByUser_idOrderCreate_time(Long user_id) {

        try (Session session = sessionFactory.openSession()) {

            Query query = session.createQuery("from UserDataEntity where userId = ? order by createDate desc ");

            query.setParameter(0, user_id);
            query.setFirstResult(0);
            query.setMaxResults(1);

            return (UserDataEntity) query.uniqueResult();

        }

    }
}
