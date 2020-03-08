package com.psl.util;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport{
    /*when you will submit the admission form
    spring MVC will run setAsText functions of this class
    Before preferring data binding task for studentName property of student object*/
	
	@Override
	public void setAsText(String studentName) throws IllegalArgumentException{
		if(studentName.contains("Mr.")||studentName.contains("Ms.")){
			setValue(studentName);
		}else{
			studentName="Mr. "+studentName;
			setValue(studentName);
		}
	}
}
