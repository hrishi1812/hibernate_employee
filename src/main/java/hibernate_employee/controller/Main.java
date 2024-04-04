package hibernate_employee.controller;

import java.util.Iterator;
import java.util.Scanner;

import hibernate_employee.dao.EmployeeDao;
import hibernate_employee.dto.Employee;

public class Main {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	Employee employee=new Employee();
	EmployeeDao dao=new EmployeeDao();
	for(;;) {
		System.out.println("Enter the Option \n1.Save \n2.Update \n3.Delete \n4.Fetch \n5.FetchAll \n6.EmployeeByName"
				+ "\n7.EmployeeByDesignation \n8.EmployeeByPhone \n9.EmployeeByEmail \n10.Exit");
		switch (scanner.nextInt()) {
		case 1:{
		    System.out.println("Enter the Id");
		    employee.setId(scanner.nextInt());
		    System.out.println("Enter the name");
		    employee.setName(scanner.next());
		    System.out.println("Enter the phone");
		    employee.setPhone(scanner.nextLong());
		    System.out.println("Enter the salary");
		    employee.setSalary(scanner.nextDouble());
		    System.out.println("Enter the Designation");
		    employee.setDesignation(scanner.next());
		    System.out.println("Enter the email");
		    employee.setEmail(scanner.next());
		    dao.saveEmployee(employee);
		}
			
			break;
		case 2:{
			 System.out.println("Enter the Id");
			    employee.setId(scanner.nextInt());
			    System.out.println("Enter the name");
			    employee.setName(scanner.next());
			    System.out.println("Enter the phone");
			    employee.setPhone(scanner.nextLong());
			    System.out.println("Enter the salary");
			    employee.setSalary(scanner.nextDouble());
			    System.out.println("Enter the Designation");
			    employee.setDesignation(scanner.next());
			    System.out.println("Enter the email");
			    employee.setEmail(scanner.next());
			    dao.updateEmployee(employee);
			
			
		}
		break;
		case 3:{
			System.out.println("Enter the Id");
		    
		    dao.deleteEmployee(scanner.nextInt());
			
			
		}
		break;
		case 4:{
			System.out.println("Enter the Id");
		    
		    dao.fetch(scanner.nextInt());
			
			
		}
		break;
		case 5:{
			dao.fetchAll();
		}
		break;
		case 6:{
			System.out.println("Enter the name");
			dao.employeeByName(scanner.next());
		}
		break;
		
		case 7:{
			System.out.println("Enter the Designation");
			dao.employeeByDesignation(scanner.next());
		}
		break;
		case 8:{
			System.out.println("Enter the phone");
			dao.employeeByPhone(scanner.nextLong());
		}
		break;
		case 9:{
			System.out.println("Enter the email");
			dao.employeeByEmail(scanner.next());
		}
		break;
		case 10:{
			System.exit(0);
		}
		default:
			System.out.println("Enter Correct option");
			break;
		}
	}
	
}
}
