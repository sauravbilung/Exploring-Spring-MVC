package com.psl.bean;

import java.util.ArrayList;
import java.util.Date;
import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//import org.hibernate.validator.constraints.NotEmpty;

//@JsonIgnoreProperties({"studentBranch"})//will ignore such keys
@JsonInclude(JsonInclude.Include.NON_NULL)// it will only include non-null key value pairs
@JsonPropertyOrder({"studentName","studentBranch","studentSkills","studentMobile","studentDOB"})//will decide in which order json data will be displayed
public class Student {
	
	//@JsonProperty("student_Name") //will change key value studentName to student_Name 
    @Pattern(regexp="[^0-9]*") //regular expression for no numbers
    private String studentName;
    
    //to make this annotation do form validation,add @valid annotation in the required controller class
    //@Size(min=2,max=30,message="please enter a value for student branch b/w {min} and {max}")
	@Size(min=2,max=30)//or we can put the message part in studentMessages properties file and let mvc know abt it
    private String studentBranch;
    
	@Max(999999999L)
    private long studentMobile;
    
	@Past // this annotation specifies that the date value should be in the past
    private Date studentDOB;
	
	private ArrayList<String> studentSkills; 
	private Address studentAddress;  
    
	public long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public Date getStudentDOB() {
		return studentDOB;
	}
	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}
	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}
	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentBranch() {
		return studentBranch;
	}
	public void setStudentBranch(String studentBranch) {
		this.studentBranch = studentBranch;
	}   
}
