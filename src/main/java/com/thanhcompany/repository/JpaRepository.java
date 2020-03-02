package com.thanhcompany.repository;

import java.util.List;
import java.util.Map;

public interface JpaRepository<T> {
	List<T> findAll(Map<String,Object> params, Object ...objects);
	List<T> findAll(String sql,Object ...objects);
	List<T> findById(Object... ids);
	void insert(String sql,Object ...objects);
	void insert(Object object);
	void update(Object object,Object ...where);
	void deleteById(Object... ids);
	void deleteRandom(Object object);
}
