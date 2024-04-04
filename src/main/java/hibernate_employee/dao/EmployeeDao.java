package hibernate_employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_employee.dto.Employee;



public class EmployeeDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("rushi").createEntityManager();
	}
	public void saveEmployee(Employee employee) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}
	public void updateEmployee(Employee employee) {
		EntityManager manager=getEntityManager();
		
		Employee employee1=manager.find(Employee.class, employee.getId());
		if (employee1!=null) {
			
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.merge(employee);
			transaction.commit();
			
		}else {
			System.out.println("Student not Present");
		}
		
	}
	public void deleteEmployee(int id) {
         EntityManager manager=getEntityManager();
		
		Employee employee1=manager.find(Employee.class, id);
		if (employee1!=null) {
			
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.remove(employee1);
			transaction.commit();
			
			
		}else {
			System.out.println("Student not Present");
		}
	}
	public void fetch(int id) {
EntityManager manager=getEntityManager();
		
		Employee employee1=manager.find(Employee.class, id);
		if (employee1!=null) {
			
			System.out.println(employee1);
			
		}else {
			System.out.println("Student not Present with given Id");
		}
	}
	public void fetchAll() {
		EntityManager manager=getEntityManager();
		Query query=manager.createQuery("SELECT e FROM Employee e ");
		List list=query.getResultList();
		if(!list.isEmpty()) {
			System.out.println(list);
		}else {
			System.out.println("Student is not Present");
		}
	}
	public void employeeByName(String name) {
		EntityManager manager=getEntityManager();
		Query query=manager.createQuery("SELECT e FROM Employee e  WHERE e.name=?1");
		query.setParameter(1, name);
		List list=query.getResultList();
		if(!list.isEmpty()) {
			System.out.println(list);
		}else {
			System.out.println("Student is not Present");
		}
	}

	public void employeeByDesignation(String designation) {
		EntityManager manager=getEntityManager();
		Query query=manager.createQuery("SELECT e FROM Employee e  WHERE e.designation=?1");
		query.setParameter(1, designation);
		List list=query.getResultList();
		if(!list.isEmpty()) {
			System.out.println(list);
		}else {
			System.out.println("Student is not Present");
		}
	}
	public void employeeByPhone(long phone) {
		EntityManager manager=getEntityManager();
		Query query=manager.createQuery("SELECT e FROM Employee e  WHERE e.phone=?1");
		query.setParameter(1, phone);
		try {
			Employee employee=(Employee) query.getSingleResult();
			System.out.println(employee);
		} catch (Exception e) {
			System.out.println("Student is not Present");
		}
		
		
	}
	public void employeeByEmail(String email) {
		EntityManager manager=getEntityManager();
		Query query=manager.createQuery("SELECT e FROM Employee e  WHERE e.email=?1");
		query.setParameter(1,email);
		try {
			Employee employee=(Employee) query.getSingleResult();
			System.out.println(employee);
		} catch (Exception e) {
			System.out.println("Student is not Present");
		}
		
		
	}
}
