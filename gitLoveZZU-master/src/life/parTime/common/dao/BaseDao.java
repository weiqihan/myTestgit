package life.parTime.common.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao <T>{

	    // ����ID����ʵ��
		T get(Class<T> entityClazz , Serializable id);
		// ����ʵ��
		Serializable save(T entity);
		// ����ʵ��
		void update(T entity);
		// ɾ��ʵ��
		void delete(T entity);
		//
		List query(String sql,Object[] values);
		//
	    List<T> query(String queryString);
		// ����IDɾ��ʵ��
		void delete(Class<T> entityClazz , Serializable id);
		// ��ȡ����ʵ��
		List<T> findAll(Class<T> entityClazz);
		List<T> findByPage(final String hql,final int pageNo, final int pageSize);
		List<T> findByPage(final String hql , final int pageNo, final int pageSize , final  Object... params);
}
