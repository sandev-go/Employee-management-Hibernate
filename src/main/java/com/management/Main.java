package com.management;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import com.model.Employee;

 

public class Main {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		String ch = "";
		do
		{
			EmployeeDao dao = new EmployeeDao();
			Employee employee = null;
			menu();
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				employee = new Employee();
				System.out.println("Enter the first name :");
				String first = sc.next();
				employee.setFirstName(first);
				
				System.out.println("Enter the Last name :");
				String last = sc.next();
				employee.setLastName(last);
				
				System.out.println("Enter Designation :");
				String des = sc.next();
				employee.setDesignation(des);
				
				System.out.println("Enter Age :");
				int age = sc.nextInt();
				employee.setAge(age);
				
				System.out.println("Enter Salary:");
				int sal = sc.nextInt();
				employee.setSalary(sal);
				dao.saveEmployee(employee);
				break;
			case 2:
				System.out.println("Enter the id for update");
				int id = sc.nextInt();
				employee = dao.getEmpById(id);
				if (employee != null)
				{
					System.out.println("Enter the first name :");
					String first2 = sc.next();
					employee.setFirstName(first2);
					
					System.out.println("Enter the Last name :");
					String last2 = sc.next();
					employee.setLastName(last2);
					
					System.out.println("Enter Designation :");
					String des2 = sc.next();
					employee.setDesignation(des2);
					
					System.out.println("Enter Age :");
					int age2 = sc.nextInt();
					employee.setAge(age2);
					
					System.out.println("Enter Salary:");
					int sal2 = sc.nextInt();
					employee.setSalary(sal2);
					dao.updateEmployee(employee);
				} else
				{
					System.out.println("Employee is not exist with id = " + id);
				}
				break;
			case 3:
				System.out.println("Enter the id for delete");
				  int identity =sc.nextInt();
				employee = dao.getEmpById(identity);
				if (employee != null)
				{
				dao.deleteEmployee(employee);
				}else {
					System.out.println("Employee is not exist with id = " + identity);
				}
				break;
			case 4:
				System.out.println("Here is the list of All the employees :");
				dao.getAll();
				break;
			case 5:
				System.out.println("Enter the id for select");
				employee = dao.getEmpById(sc.nextInt());
				System.out.println(employee.getId());
				System.out.println(employee.getAge());
				break;

			case 6:
				System.out.println("Do you want to Download All Employees List ? Y/N");
				 
				if("Y".equalsIgnoreCase(sc.next()))
				{
					dao.Download();
				}
				 
				break;
			case 7:
				
				System.out.println("You are Existing ...");
				System.exit(0);
				break;
			default:
				break;
			}
			System.out.println("Do you want to continue?(Y/N)");
			ch = sc.next();

		} while ("Y".equalsIgnoreCase(ch));
		sc.close();
	}

	private static boolean validate()
	{

		return false;

	}

	private static void menu()
	{
		System.out.println("1. create employee");
		System.out.println("2. update employee");
		System.out.println("3. delete employee");
		System.out.println("4. get all employee");
		System.out.println("5. get employee by id");
		System.out.println("6. Download");
		System.out.println("7. exit");
	}
}

 
