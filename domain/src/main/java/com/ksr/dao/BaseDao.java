package com.ksr.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao {

	public List<Map<String, Object>> select(String sql,Object... args);
	
	public long insert(String sql,Object... args);
	
	public long update(String sql,Object... args);
	
	public long delete(String sql,Object... args);
}
