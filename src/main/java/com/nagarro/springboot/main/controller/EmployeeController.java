package com.nagarro.springboot.main.controller;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.springboot.main.entity.Employee;
import com.nagarro.springboot.main.service.EmployeeService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeService es;
	
	@RequestMapping("/update")
	public ModelAndView udpate(@RequestParam("user") String user,@RequestParam("id") int id,
			@RequestParam("Name") String name,@RequestParam("Loc") String loc,@RequestParam("email") String email,
			@RequestParam("dob") String dob)
	{
		System.out.println(id);
		Employee e=new Employee(id,name,loc,email,dob);
		es.update(e);
		List<Employee> l=es.getEmployees();
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",user);
		mv.addObject("list",l);
		mv.setViewName("display");
		return mv;
	}
	
	@RequestMapping("/Upload")
	public ModelAndView upload(@RequestParam("user") String user,@RequestParam("id") int id,
			@RequestParam("Name") String name,@RequestParam("Loc") String loc,@RequestParam("email") String email,
			@RequestParam("dob") String dob)
	{
		ModelAndView mv=new ModelAndView();
		Employee e=new Employee(id,name,loc,email,dob);
		es.upload(e);
		List<Employee> l=es.getEmployees();
		mv.addObject("list",l);
		mv.setViewName("display");
		return mv;
	}
}
