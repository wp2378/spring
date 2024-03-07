package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mapper.DeptMapper;
import com.sample.mapper.EmpMapper;
import com.sample.vo.Dept;
import com.sample.vo.Employees;
import com.sample.web.form.DeptCreateForm;
import com.sample.web.form.EmpCreateForm;

@Service
public class HrService {

	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private EmpMapper empMapper;
	
	public List<Dept> getAllDepts() {
		
		return deptMapper.getAllDepts();
	}

	public void createDept(DeptCreateForm deptForm) {
		
		Dept dept = Dept.builder()
				.name(deptForm.getName())
				.tel(deptForm.getTel())
				.fax(deptForm.getFax())
				.build();
		
		deptMapper.insertDept(dept);
	}
	
	public List<Employees> getAllEmployees() {
		
		return empMapper.getAllEmployees();
	}

	public Employees getEmployeesByNo(int no) {
		
		return empMapper.getEmployeesByNo(no);
		
	}

	public void createEmp(EmpCreateForm empForm) {
		
		
		Dept dept = Dept.builder()
				.no(empForm.getDeptNo())
				.build();
		
		Employees emp = Employees.builder()
					.name(empForm.getName())
					.tel(empForm.getTel())
					.email(empForm.getEmail())
					.salary(empForm.getSalary())
					.hireDate(empForm.getHireDate())
					.dept(dept)
					.build();
					
		
		empMapper.insertEmployees(emp);
		
	}
}
