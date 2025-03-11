package com.J1ggy.testingExercise05;



import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestServiceBusImpl{  //Create a class to Test our Business implementation
	private ServiceInterface service;  //Create a field called "service" which can hold an instance of a class that
	                                   //Implements the Customers "ServiceInterface"
	                                   //Must implement "public List<Student>retrieveStudents()"
	
	private ServiceBusImpl serviceBusImpl; //Create an instance of the class "ServiceBusImpl"
	                                       //Which ~ PROVIDES OUR BUSINESS LOGIC
	                                   //ie:(CONTAINS THE METHOD "getStudentsFilteredByCourse()" THAT WE WANT TO TEST)
	
	
	@BeforeEach                      //Things to happen before each Unit Test
	public void initEach(){
		service = new ServiceInterfaceStub();//CREATES A STUB INSTANCE AND ASSIGNS IT TO "service" (our "ServiceInterface")
		                                      //The Constructor of "ServiceInterfaceStub" populates a List 
		                                      //within the STUB with "Student" instances
		                                      //REMEMBER ServiceInterfaceStub IMPLEMENTS ServiceInterface
		                                      //SO THE VARIABLE  "service" is the STUB
		
		
		serviceBusImpl = new ServiceBusImpl(service);//The instance of "ServiceBusImpl" utilises the STUB in
		                                             //it's Constructor "ServiceBusImpl(service)"
		                                             //"serviceBusImpl" is an Instance of the class "ServiceBusImpl"
		                                             //our business logic
		                                             //and our instance has a ServiceInterface field which references
		                                             //a STUB containing a list which can hold "Student" instances
		                                        //REMEMBER the Constructor of ServiceInterfaceStub" populated the List

	}
	@AfterEach                               //Things to do after each unit test is run (We only have one Unit Test
	public void cleanUpEach(){
		service = null;                       // Drop the service and serviceBusImpl instances
		serviceBusImpl = null;                // If we keep them then they hold data and may adversely affect subsequent tests
	}
	@Test
	public void usingAStub() { //Tests the getStudentsFilteredByCourse() method using a STUB

		List<Student> students =  serviceBusImpl.getStudentsFilteredByCourse("Woodwork");//call method with parameter "Woodwork"
		assertEquals(3, students.size()); //Use "assertEquals" to double check that it has returned the correct number of instances
	}


}


