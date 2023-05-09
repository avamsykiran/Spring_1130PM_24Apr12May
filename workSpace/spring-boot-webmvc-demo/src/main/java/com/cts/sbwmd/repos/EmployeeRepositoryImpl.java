package com.cts.sbwmd.repos;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.sbwmd.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private RowMapper<Employee> getRowMapper() {
		return (rs, rowId) -> (new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
	}

	public static final String SELECT_ALL_QRY = "SELECT empid,ename,sal FROM emps";
	public static final String SELECT_BY_ID_QRY = "SELECT empid,ename,sal FROM emps WHERE empId=:empId";
	public static final String INS_QRY = "INSERT INTO emps(ename,sal) VALUES(:empName,:salary)";
	public static final String UPD_QRY = "UPDATE emps SET ename=:empName, sal=:salary WHERE empId=:empId";
	public static final String DEL_QRY = "DELETE FROM emps WHERE empId=:empId";

	@Override
	public List<Employee> findAll() {
		return this.jdbcTemplate.query(SELECT_ALL_QRY, getRowMapper());
	}

	@Override
	public Employee findById(int empId) {
		return this.jdbcTemplate.queryForObject(SELECT_BY_ID_QRY, Collections.singletonMap("empId",empId), getRowMapper());
	}

	@Override
	public Employee add(Employee emp) {
		int n = this.jdbcTemplate.update(INS_QRY, new BeanPropertySqlParameterSource(emp));
		return emp;
	}

	@Override
	public Employee save(Employee emp) {
		int n = this.jdbcTemplate.update(UPD_QRY, new BeanPropertySqlParameterSource(emp));
		return emp;
	}

	@Override
	public void deleteById(int empId) {
		this.jdbcTemplate.update(DEL_QRY,Collections.singletonMap("empId",empId));
	}

}
