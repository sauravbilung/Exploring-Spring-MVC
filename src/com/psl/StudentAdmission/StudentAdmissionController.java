package com.psl.StudentAdmission;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.psl.bean.Student;
import com.psl.util.StudentNameEditor;

@Controller
public class StudentAdmissionController {
   
   @RequestMapping(value="/admissionForm.html",method=RequestMethod.GET)	
   public ModelAndView getAdmissionForm(){
	   //RequestMethod.GET means this function can only process request of type GET
	   ModelAndView model=new ModelAndView("AdmissionForm");
	   return model;
   }
   
   @InitBinder
   public void initbinder(WebDataBinder binder){
	//this is used to manually decide how binding should happen
	  //this function can have any name 
	   //binder.setDisallowedFields(new String[]{"studentMobile"});
	   SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
	   //CustomDateEditor is a property editor which spring uses to perform Data Binding
	   binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(sdf,false));
	   //when no propertyEditor satisfies our need we can create our own property editer.Here is the example
       binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
   }
   
   /*@RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
   public ModelAndView submitAdmissionForm(@RequestParam(value="studentName",defaultValue="Empty") String name,@RequestParam("studentBranch") String branch){
   ModelAndView model=new ModelAndView("AdmissionSuccess");
   model.addObject("msg","Details submitted by you : "+ name + ", Preferred Branch :"+branch);
   return model;
   }*/
   
  /* @RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
   public ModelAndView submitAdmissionForm(@RequestParam(value="studentName",defaultValue="Empty") String name,@RequestParam("studentBranch") String branch){
	  //Recommended method
	  Student student = new Student();
	  student.setStudentName(name);
	  student.setStudentBranch(branch);
	  
	   ModelAndView model=new ModelAndView("AdmissionSuccess");
	   model.addObject("headerMsg","Your details have been submitted successfully!!");
	   model.addObject("student", student);
	return model;	   
   }*/
   
   @ModelAttribute
   public void addingCommomObjects(Model model1){
   //adding common attributes to all the model objects in this controller
   //this function is always called first
   //a.k.a DATA Binding
   model1.addAttribute("headerMsg", "ABC college of Engineering");
   }
   
   @RequestMapping(value="/submitAdmissionForm.html", method=RequestMethod.POST)
   public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student") Student student,BindingResult result){
	   //if there is error then BindingResult helps
	    if(result.hasErrors()){
	    	return new ModelAndView("AdmissionForm");	    	
	    }
	   
	  //It binds corresponding attributes of Student object with corresponding form elements. 
	  //Hence both the name of form elements should be same attribute names of object
	   ModelAndView model=new ModelAndView("AdmissionSuccess");
	   model.addObject("headerMsg","Your details have been submitted successfully!!");
	   
	return model;	   
   }  
}
