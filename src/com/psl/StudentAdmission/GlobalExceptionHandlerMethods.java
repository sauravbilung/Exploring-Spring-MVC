package com.psl.StudentAdmission;

//import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandlerMethods {
	//with Controller Advice if exception happens in any controller class throughout the program methods in this class will be called
	    
	    //@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(value=NullPointerException.class)
		public String handleNullPointerException(Exception e){
			//logging Null Pointer Exception
			System.out.println("NullPointerException: "+ e);
			//return viewName
			return "Exception";		
		}
		
		//@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler(value=Exception.class)
		public String handleException(Exception e){
			//logging Null Pointer Exception
			System.out.println("Unknown Exception occurred: "+ e);
			//return viewName
			return "Exception";		
		}
}
