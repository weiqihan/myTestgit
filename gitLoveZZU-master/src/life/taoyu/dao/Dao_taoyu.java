package life.taoyu.dao;

import java.util.List;



public interface Dao_taoyu {
	//HQL���²���
	public <T,S> List<T> hqlquery(String sql,S action,int num);
}
