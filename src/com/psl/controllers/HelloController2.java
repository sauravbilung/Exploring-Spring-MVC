package com.psl.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//No need to extend base class controller
@Controller
@RequestMapping("/greet")
public class HelloController2{
	//with RequestMApping at the top the url now becomes
	// https://http://localhost:8080/SpringMVC/greet/(hi or welcome)	
	
    @RequestMapping("/welcome")
	public ModelAndView HelloWorld(){
		ModelAndView modelandview = new ModelAndView("HelloPage");
		String msg="Hello, Data from annotation based hello controller(Hello Controller 2), HelloWorld() is called by front controller";
		modelandview.addObject("message",msg);
		return modelandview;
	}
    
    @RequestMapping("/hi")
	public ModelAndView HelloWorld2(){
		ModelAndView modelandview = new ModelAndView("HelloPage");
		String msg="Hello, Data from annotation based hello controller(Hello Controller 2), HelloWorld2() is called by front controller";
		modelandview.addObject("message",msg);
		return modelandview;
	}
    
    @RequestMapping("/welcome/{countryName}/{userName}")
  	public ModelAndView HelloWorld3(@PathVariable("countryName") String country,@PathVariable("userName") String name){
    	ModelAndView modelandview = new ModelAndView("HelloPage");
  		String msg="Hello,"+ name +". You are from " + country;
  		modelandview.addObject("message",msg);
  		return modelandview;
  	}
    
    @RequestMapping("/hi/{countryName}/{userName}")
  	public ModelAndView HelloWorld4(@PathVariable Map<String,String> pathVars){
    	
    	String country=pathVars.get("countryName");
    	String name=pathVars.get("userName");
    	ModelAndView modelandview = new ModelAndView("HelloPage");
  		String msg="Hello "+ name +". You are from " + country;
  		modelandview.addObject("message",msg);
  		return modelandview;
  	}
}
