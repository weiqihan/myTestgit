package com.zzu.dao;

import java.io.Serializable;
import java.util.List;



public interface Dao {

	//�������
	public <T> Serializable save(T t);
	//��ѯ����
	public <T> List<T> query(String sql,String values);
	//���²���
	public <T> T update(T t);
}
