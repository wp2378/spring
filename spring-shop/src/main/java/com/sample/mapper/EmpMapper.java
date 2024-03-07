package com.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sample.vo.Employees;

@Mapper
public interface EmpMapper {

	List<Employees> getAllEmployees();

	Employees getEmployeesByNo(int no);

	void insertEmployees(Employees employees);

	
}
