package com.fh.dao;

public interface DAO {

    /**
     * 保存对象
     *
     * @param str
     * @param obj
     * @return
     */
    Object save(String str, Object obj);

    /**
     * 修改对象
     *
     * @param str
     * @param obj
     * @return
     */
    Object update(String str, Object obj);

    /**
     * 删除对象
     *
     * @param str
     * @param obj
     * @return
     */
    Object delete(String str, Object obj);

    /**
     * 查找对象
     *
     * @param str
     * @param obj
     * @return
     */
    Object findForObject(String str, Object obj);

    /**
     * 查找对象
     *
     * @param str
     * @param obj
     * @return
     */
    Object findForList(String str, Object obj);

    /**
     * 查找对象封装成Map
     *
     * @param sql
     * @param obj
     * @return
     * @throws Exception
     */
    Object findForMap(String sql, Object obj, String key, String value);

}
