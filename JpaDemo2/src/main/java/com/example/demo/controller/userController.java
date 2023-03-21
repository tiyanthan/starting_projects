package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.employedao;
import com.example.demo.model.employee;

@Controller
public class userController {
	
	@Autowired
	employedao employedao;
	
	@RequestMapping("index")
	public String index()
	{
		return "index.jsp";
	}
	
	
	@RequestMapping("addEmployee")
	public String addEmployee(employee employee)
	{
		employedao.save(employee);
		return "index.jsp";
	}
	@RequestMapping("displayEmployee")
	public ModelAndView displayEmployee(@RequestParam int id)
	{
		ModelAndView mav =new ModelAndView("showEmployee.jsp");
		employee employee= employedao.findById(id).orElse(new employee());
		mav.addObject(employee);
		return mav;
	}
	@RequestMapping("DeleteEmployee")
	public ModelAndView DeleteEmployee(@RequestParam int id)
	{
		ModelAndView mav =new ModelAndView("deleteEmployee2.jsp");
		employee employee= employedao.findById(id).orElse(new employee());
		employedao.deleteById(id);
		mav.addObject(employee);
		
		return mav;
	}
	
	@RequestMapping("updateEmployee")
	public ModelAndView updateEmployee(employee employee)
	{
		ModelAndView mav =new ModelAndView("updateEmployee.jsp");
		employee= employedao.findById(employee.getId()).orElse(new employee());
		employedao.deleteById(employee.getId());
		mav.addObject(employee);
		
		return mav;
	}


}
