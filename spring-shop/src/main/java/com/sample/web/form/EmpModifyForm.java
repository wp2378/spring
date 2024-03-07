package com.sample.web.form;

import com.sample.vo.Employees;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmpModifyForm extends EmpCreateForm {

	private int no;
	
	@Override
	public Employees toEmp() {
		Employees emp = super.toEmp();
		emp.setNo(no);
		return emp;
	}
}
