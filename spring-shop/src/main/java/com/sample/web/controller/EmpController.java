package com.sample.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.HrService;
import com.sample.vo.Dept;
import com.sample.vo.Employees;
import com.sample.web.form.EmpCreateForm;
import com.sample.web.form.EmpModifyForm;

@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private HrService hrService;
	
	@GetMapping(path="/list")
	public String list(Model model) {
		List<Employees> empList = hrService.getAllEmployees();
		model.addAttribute("empList", empList);
		
		return "emp/list";
	}
	
	@GetMapping("/detail")
	public String detail(int no, Model model) {
		Employees employees = hrService.getEmployeesByNo(no);
		model.addAttribute("employees", employees);
		
		return "emp/detail";
	}
	
	@GetMapping("/create")
	public String create() {
			
		return "emp/fome";
	}
	
	@PostMapping("/create")
	public String createEmp(EmpCreateForm empCreateForm) {
		hrService.createEmp(empCreateForm);
		
		return "redirect:list";
	}
	
	@GetMapping("/modify")
	public String modify(int no, Model model) {
		Employees employees = hrService.getEmployeesByNo(no);
		model.addAttribute("emp", employees);
		List<Dept> deptList = hrService.getAllDepts();
		model.addAttribute("deptList", deptList);
		
		return "emp/modify";
	}
	
	@PostMapping("/modify")
	public String empModify(EmpModifyForm empModifyform) {
			hrService.ModifyEmp(empModifyform);
		
		return "redirect:detail?no=";
	}
	
	
}
