package com.psl.StudentAdmission;

import java.util.ArrayList;
import java.util.Iterator;

//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.psl.bean.Student;

//@Controller
@RestController // with this annotation we don't need to specifically mention @ResponseBody annotation to let MVC know that
//the specified method is a REST API method, by default all the methods in this class are REST API methods 
public class StudentInfoRESTAPIController {
	
	    ArrayList<Student> studentList = new ArrayList<Student>();
	    int check=0;
	   //******************************************** Retrieving All Student Records ****************************************************
	   //@ResponseBody //with this annotation we are telling MVC framework not to look for any view rather convert the returned data to appropriate format and send it to the client
	   @RequestMapping(value="/students", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	   //by using "produces" in RequestMapping we are restricting this REST API method to send data only in a particular format
	   public ArrayList<Student> getStudentsList(){
		  if(check==0){
		   check++;	  
		   Student student1=new Student();
			student1.setStudentName("Captain America");
			student1.setStudentMobile(313313L);
			
			Student student2=new Student();
			student2.setStudentName("Iron Man");		
			student2.setStudentMobile(6523L);
			
			Student student3=new Student();
			student3.setStudentName("Hulk");
			student3.setStudentMobile(97654L);
			
			studentList.add(student1);
			studentList.add(student2);
			studentList.add(student3);  
		} 
		return studentList;	   
	   }
	   
	   //********************* REST API part to retrieve a particular record*********************************************
	   //@ResponseBody
	   @RequestMapping(value="/students/{name}",method=RequestMethod.GET)
	   public ResponseEntity<Student> getStudent(@PathVariable("name") String studentName) {
		  //PathVariable fetches data from element in URI which is inside {} braces 
		  //fetch the student's record using "studentName" from DB
		  Student student=new Student();
		  Iterator<Student> itr=studentList.iterator();
		    while(itr.hasNext()){
		    	student=itr.next();
		    	 if(student.getStudentName().equals(studentName)){
		    		 return new ResponseEntity<Student>(student,HttpStatus.FOUND);	 
		    	 }
		    }
		    return new ResponseEntity<Student>(student,HttpStatus.NOT_FOUND);	   
	   }
	   
	   //**********************************Updating student record********************************************************
	   @RequestMapping(value="/students/{name}",method=RequestMethod.PUT , consumes=MediaType.APPLICATION_JSON_VALUE)
	   //with "consumes" we can only accept specific type of input value
	   public ResponseEntity<String>updateStudent(@PathVariable("name") String studentName, @RequestBody Student student){
		//with @RequestBody annotation we are binding the data which is sent by the client which can be 
		//in whatever format to an object of Student class
		   //ResponseEntity is used set status codes and response body
	    int i=0; 
	    for(Student std:studentList){
	    	if(std.getStudentName().equals(studentName)){
			  studentList.set(i,student);
			  return new ResponseEntity<String>("Record updated !!!",HttpStatus.OK);	
		    }
	       i++;	
	    }
		//find the matching student record using "studentName" from the DB
		//update the matching student record with the information of student sent by the client
		//return true if update is done successfully else return false
		//but generally we send only HTTP status codes and using this the client can understand that something is wrong
		//with status code we can also return objects. If do not wish to sent any data use "Void"
		//implement if else clause and set appropriate status codes
		/*HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.add("key1","value1");
		httpHeaders.add("key2","value2");
		return new ResponseEntity<Void>(httpHeaders,HttpStatus.OK);		*/ 
	    return new ResponseEntity<String>("Record not found !!!",HttpStatus.NOT_FOUND);		
	   }
	   
	   @RequestMapping(value="/students",method=RequestMethod.POST)
	   public ResponseEntity<String> postStudent(@RequestBody Student student){
		 studentList.add(student);
		 //Business logic goes here
		 //also tell user how to access the inserted record
		 return new ResponseEntity<String> ("Created Successfully !!!",HttpStatus.CREATED);
	   }
	   
	   @RequestMapping(value="/students/{name}",method=RequestMethod.DELETE)
	   public ResponseEntity<String> deleteStudent(@PathVariable("name") String studentName,@RequestBody Student student){
		 int foundAt=0;
		 for(Student std:studentList){
			if(std.getStudentName().equals(studentName)){
				studentList.remove(foundAt);
				return new ResponseEntity<String> ("Record Deleted !!!",HttpStatus.OK);
			}
			foundAt++;
		 }
		 //Business logic goes here
		 return new ResponseEntity<String> ("Record not found !!!",HttpStatus.NOT_FOUND);
	   }
	   
	   @RequestMapping(value="/students",method=RequestMethod.DELETE)
	   public ResponseEntity<String> deleteAllStudent(@PathVariable("name") String studentName,@RequestBody Student student){
		 if(studentList.isEmpty()){
			 return new ResponseEntity<String> ("Database is Empty !!!",HttpStatus.NO_CONTENT); 
		 }
		 //Business logic goes here
		 //also tell user how to access the inserted record
		 return new ResponseEntity<String>("Deletion Successfull !!!",HttpStatus.OK);
	   }
	   
}
