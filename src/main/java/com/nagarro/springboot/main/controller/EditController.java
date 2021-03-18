package com.nagarro.springboot.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditController 
{
	@RequestMapping("/EditC")
	public ModelAndView edit(@RequestParam("id") int id,@RequestParam("username") String username)
	{
		ModelAndView mv=new ModelAndView();
		System.out.println(id);
		mv.addObject("user", username);
		mv.addObject("id",id);
		mv.setViewName("edit");
		return mv;
	}
}
