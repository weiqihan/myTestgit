package com.zzu.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import life.treeHole.common.dao.BaseDao;

import org.hibernate.*;

public class BaseDaoHibernate5 <T> implements BaseDao<T> {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Override
	public T get(Class<T> entityClazz, Serializable id) {
		return hibernateTemplate.get(entityClazz, id);
	}

	@Override
	public Serializable save(T entity) {
		return hibernateTemplate.save(entity);
	}

	@Override
	public void update(T entity) {
		hibernateTemplate.saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		hibernateTemplate.delete(entity);
	}

	@Override
	public void delete(Class<T> entityClazz, Serializable id) {
		delete(get(entityClazz, id));	
	}

	@Override
	public List<T> findAll(Class<T> entityClazz) {
		
		return (List<T>)hibernateTemplate.find("select en from " + entityClazz.getSimpleName() + " en");
	}
	/**
	 * ʹ��hql �����з�ҳ��ѯ����
	 * @param hql ��Ҫ��ѯ��hql���
	 * @param pageNo ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @return ��ǰҳ�����м�¼ 
	 */
	@Override
	public List<T> findByPage(String hql, int pageNo, int pageSize) {
		// ͨ��һ��HibernateCallback������ִ�в�ѯ
		List<T> list = hibernateTemplate
			.execute(new HibernateCallback<List<T>>()
		{
			// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
			public List<T> doInHibernate(Session session)
			{
				// ִ��Hibernate��ҳ��ѯ
				List<T> result = session.createQuery(hql)
					.setFirstResult((pageNo - 1) * pageSize)
					.setMaxResults(pageSize)
					.list();
				return result;
			}
		});
		return list;
	}
	/** 
	 * ʹ��hql �����з�ҳ��ѯ����
	 * @param hql ��Ҫ��ѯ��hql���
	 * @param pageNo ��ѯ��pageNoҳ�ļ�¼
	 * @param pageSize ÿҳ��Ҫ��ʾ�ļ�¼��
	 * @param params ���hql��ռλ��������params���ڴ���ռλ������
	 * @return ��ǰҳ�����м�¼
	 */
	@Override
	public List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
		// ͨ��һ��HibernateCallback������ִ�в�ѯ
		List<T> list = hibernateTemplate
			.execute(new HibernateCallback<List<T>>()
		{
			// ʵ��HibernateCallback�ӿڱ���ʵ�ֵķ���
			public List<T> doInHibernate(Session session)
			{
				// ִ��Hibernate��ҳ��ѯ
				Query query = session.createQuery(hql);
				// Ϊ����ռλ����HQL������ò���
				for(int i = 0 , len = params.length ; i < len ; i++)
				{
					query.setParameter(i + "" , params[i]);
				}
				List<T> result = query.setFirstResult((pageNo - 1) * pageSize)
					.setMaxResults(pageSize)
					.list();
				return result;
			}
		});
		return list;
	}
	@Override
	public List query(String sql, Object[] values) {
		
		return (List)hibernateTemplate.find(sql, values);
	}
	@Override
	public List<T> query(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}
}
