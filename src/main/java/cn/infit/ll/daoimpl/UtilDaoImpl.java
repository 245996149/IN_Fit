package cn.infit.ll.daoimpl;

import cn.infit.ll.dao.SuperDao;
import cn.infit.ll.dao.UtilDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * Created by kaxia on 2017/6/15.
 */
@Repository
public class UtilDaoImpl extends SuperDao implements UtilDao {


    @Override
    public boolean save(Object obj) {

        boolean flag = false;

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        try {

            session.save(obj);

            transaction.commit();

            flag = true;

        } catch (Exception e) {

            e.printStackTrace();
            transaction.rollback();

        } finally {

            session.close();

        }

        return flag;

    }

    @Override
    public boolean update(Object obj) {

        boolean flag = false;

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        try {

            session.update(obj);

            transaction.commit();

            flag = true;

        } catch (Exception e) {

            e.printStackTrace();
            transaction.rollback();

        } finally {

            session.close();

        }

        return flag;

    }
}
