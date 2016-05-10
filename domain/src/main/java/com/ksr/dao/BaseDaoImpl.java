package com.ksr.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("BaseDao")
public class BaseDaoImpl implements BaseDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Map<String, Object>> select(String sql,Object... args){
		return jdbcTemplate.queryForList(sql,args);
	}
	@Override
	public long insert(String sql,Object... args){
		return jdbcTemplate.update(sql, args);
	}
	@Override
	public long update(String sql,Object... args){
		return jdbcTemplate.update(sql, args);
	}
	@Override
	public long delete(String sql,Object... args){
		return jdbcTemplate.update(sql, args);
	}
}
