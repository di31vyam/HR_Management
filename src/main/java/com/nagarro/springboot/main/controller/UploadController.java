package com.nagarro.springboot.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController 
{
	@RequestMapping("/uploadC")
	public ModelAndView upload(@RequestParam("username") String user)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("upload");
		return mv;
	}
}
