package cn.infit.ll.dao;

/**
 * Created by kaxia on 2017/6/15.
 */
public interface UtilDao {

    /**
     * 想数据库中新增一个对象
     *
     * @param obj 需要新增的对象
     * @return 是否操作成功
     */
    boolean save(Object obj);

    boolean update(Object obj);

}
