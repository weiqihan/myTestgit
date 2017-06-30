package persionalCenter.dao;

import java.io.Serializable;
import java.util.List;



public interface Dao {

	//�������
	public <T> Serializable save(T t);
	//��ѯ����
	public <T> List<T> query(String sql,String values1,String values2);
	public <T,S> List<T> query(String sql,S values);
	//���²���
	public <T> T update(T t);
	//ɾ������
	public <T> void delete(T t);

}
