package com.J1ggy.testingExercise05;

import java.util.ArrayList;
import java.util.List;


public class ServiceBusImpl {
	private ServiceInterface service; //DECLARES A FIELD TO HOLD "ServiceInterfaceStub" OUR POPULATED STUB WITH "Student" DATA LIST
                                      //REMEMBER - "ServiceInterfaceStub" IMPLEMENTS THE CUSTOMER INTERFACE "ServiceInterface"
	public ServiceBusImpl(ServiceInterface service) {   //The Constructor accepts an instance of (In our case a "ServiceInterfaceStub")
		this.service = service;   //Our populated STUB (the "ServiceInterfaceStub" )is assigned to the ServiceInterface variable "service"
	}



	
	public List<Student> getStudentsFilteredByCourse(String course){//THE METHOD TO BE TESTED TAKES A String (course) as a parameter
		   List <Student> filteredResult = new ArrayList<>();       //Create an ArrayList to hold the filtered result
		   List <Student> getAllStudents = service.retrieveStudents(); //Assign List "getAllStudents to result of a method "retrieveStudents()" of "ServiceInterfaceStub" that returns ALL students
				   for (Student std : getAllStudents) { //iterate the List getAllStudents and assign Students matching "course" to List "filteredResult"
					   if (std.getCourse().contains(course)) {
							filteredResult.add(std);
							System.out.format("%06d", std.getID());  // Print the ID and name of matching instances of "Student"
							System.out.println(", " +std.getName() + " are on " + course);
						}
				   }

		return filteredResult; //return the filteredResult

		}

}