package manytomanybie2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybie2.dto.Courses;
import manytomanybie2.dto.Student;

public class StudentDao {
	public void updateStudent(int id,Student student) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			entityTransaction.begin();
			student.setId(id);
			student.setCourses(dbStudent.getCourses());
            entityManager.merge(student);
			entityTransaction.commit();
		}else {
			System.out.println("id is not present");
		}	
	}
	public void deleteStudent(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
//			id is present
			entityTransaction.begin();
			entityManager.remove(dbStudent);
			entityTransaction.commit();
		}else {
			System.out.println("id is not present");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
