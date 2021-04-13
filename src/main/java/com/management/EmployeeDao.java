package com.management;

 

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Employee;
import com.util.Utility;

public class EmployeeDao {
	
	Session session = Utility.getSession();

	public void saveEmployee(Employee employee) {
			
		session.save(employee);
		Transaction tx= session.beginTransaction();
		tx.commit();
 
	}

	public Employee getEmpById(int id) {
		Employee emp=session.get(Employee.class, id);
		return emp;
	}

	public void updateEmployee(Employee employee) {
		session.update(employee);
		Transaction tx= session.beginTransaction();
		tx.commit();
 
		
	}

	public void deleteEmployee(Employee employee) {
		session.delete(employee);
		Transaction tx= session.beginTransaction();
		tx.commit();
		
	}

	public void getAll() {
		//Query the Employees
				List<Employee> theEmployees=
					session.createQuery("from Employee").getResultList();
				
				//Display the Students
				for ( Employee theEmp : theEmployees)
				{
					System.out.println(
							theEmp.getId()+"  "+
									theEmp.getFirstName()+"  "+
									theEmp.getLastName()+"  "+
									theEmp.getDesignation()+"  "+
									theEmp.getAge()+"  "+
									theEmp.getSalary());
				}
				 
		
	}

	public List<Employee> getList() {
		 
		return  session.createQuery("from Employee").getResultList();
	}
	
	public void Download() {
		 try {
		        File file=new File("fileMap.txt");
		        FileOutputStream fos=new FileOutputStream(file);
		        PrintWriter pw=new PrintWriter(fos);

		        for(Employee theEmp:getList()){
		            pw.println( theEmp.getId()+"  "+
							theEmp.getFirstName()+"  "+
							theEmp.getLastName()+"  "+
							theEmp.getDesignation()+"  "+
							theEmp.getAge()+"  "+
							theEmp.getSalary());
		        }

		        pw.flush();
		        pw.close();
		        fos.close();
		        System.out.println("End writting File");
		    } catch(Exception e) {}
		
	}

}
