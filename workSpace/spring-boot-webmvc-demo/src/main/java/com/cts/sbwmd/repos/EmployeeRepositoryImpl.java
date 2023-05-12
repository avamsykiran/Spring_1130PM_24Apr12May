package com.cts.sbwmd.repos;

import java.sql.Date;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.sbwmd.model.Designation;
import com.cts.sbwmd.model.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	private RowMapper<Employee> getRowMapper() {
		return (rs, rowId) -> (new Employee(
					rs.getInt(1), 
					rs.getString(2), 
					rs.getDouble(3),
					rs.getString(4)==null?null:Designation.valueOf(rs.getString(4)),
					rs.getDate(5)==null?null:rs.getDate(5).toLocalDate()
				)
			);
	}
	
	private Map getParamsMap(Employee emp) {
		Map paramsMap = new HashMap();
		
		paramsMap.put("empId", emp.getEmpId());
		paramsMap.put("empName",emp.getEmpName());
		paramsMap.put("salary", emp.getSalary());
		paramsMap.put("designation",emp.getDesignation().toString());
		paramsMap.put("dateOfJoining", Date.valueOf(emp.getDateOfJoining()));
		
		return paramsMap;
	}

	public static final String SELECT_ALL_QRY = "SELECT empid,ename,sal,desg,joindate FROM emps";
	public static final String SELECT_BY_ID_QRY = "SELECT empid,ename,sal,desg,joindate FROM emps WHERE empId=:empId";
	public static final String SELECT_BY_NAME_QRY = "SELECT empid,ename,sal,desg,joindate FROM emps WHERE ename LIKE :empName";
	public static final String INS_QRY = "INSERT INTO emps(ename,sal,desg,joindate) VALUES(:empName,:salary,:designation,:dateOfJoining)";
	public static final String UPD_QRY = "UPDATE emps SET ename=:empName, sal=:salary,desg=:designation,joindate=:dateOfJoining WHERE empId=:empId";
	public static final String DEL_QRY = "DELETE FROM emps WHERE empId=:empId";

	@Override
	public List<Employee> findAll() {
		return this.jdbcTemplate.query(SELECT_ALL_QRY, getRowMapper());
	}

	@Override
	public List<Employee> findByEmployeeName(String empName){
		return this.jdbcTemplate.query(SELECT_BY_NAME_QRY, Collections.singletonMap("empName","%"+empName+"%"),getRowMapper());
	}
	
	@Override
	public Employee findById(int empId) {
		return this.jdbcTemplate.queryForObject(SELECT_BY_ID_QRY, Collections.singletonMap("empId",empId), getRowMapper());
	}

	@Override
	public Employee add(Employee emp) {
		//int n = this.jdbcTemplate.update(INS_QRY, new BeanPropertySqlParameterSource(emp));
		int n = this.jdbcTemplate.update(INS_QRY,getParamsMap(emp));
		return emp;
	}

	@Override
	public Employee save(Employee emp) {
		//int n = this.jdbcTemplate.update(UPD_QRY, new BeanPropertySqlParameterSource(emp));
		int n = this.jdbcTemplate.update(UPD_QRY, getParamsMap(emp));
		return emp;
	}

	@Override
	public void deleteById(int empId) {
		this.jdbcTemplate.update(DEL_QRY,Collections.singletonMap("empId",empId));
	}

}
