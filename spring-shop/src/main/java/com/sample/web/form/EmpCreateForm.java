package com.sample.web.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.sample.vo.Dept;
import com.sample.vo.Employees;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpCreateForm {

	private String name;
	private String tel;
	private String email;
	private int salary;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	private int deptNo;
	
	@Builder
	public EmpCreateForm(String name, String tel, String email, int salary, Date hireDate, int deptNo) {
		super();
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.salary = salary;
		this.hireDate = hireDate;
		this.deptNo = deptNo;
		


	}

	public Employees toEmp() {
		Employees emp = new Employees();
		emp.setName(name);
		emp.setTel(tel);
		emp.setEmail(email);
		emp.setSalary(salary);
		emp.setHireDate(hireDate);
		
		Dept dept = new Dept();
		dept.setNo(deptNo);
		emp.setDept(dept);
		return emp;
	}
	
}
	
	
	

