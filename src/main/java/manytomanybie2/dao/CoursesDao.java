package manytomanybie2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybie2.dto.Courses;
import manytomanybie2.dto.Student;

public class CoursesDao {

	public void updateCourses(int id,Courses courses) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Courses dbCourses=entityManager.find(Courses.class, id);
		if(dbCourses!=null) {
			entityTransaction.begin();
			courses.setId(id);
			courses.setStudents(dbCourses.getStudents());
			entityManager.merge(courses);
			entityTransaction.commit();
		}else {
			System.out.println("id is not present");
		}	
	}
	
	public void deleteCourses(int id) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		Courses dbCourses=entityManager.find(Courses.class, id);
		if(dbCourses!=null) {
//			id is present
			entityTransaction.begin();
			List<Student> list=dbCourses.getStudents();
//			this list is a list of students who are taking a java
			for(Student student:list) {
				List<Courses> courses=student.getCourses();
				courses.remove(dbCourses);
			}
			
			entityManager.remove(dbCourses);
			entityTransaction.commit();
		}else {
			System.out.println("id is not present");
		}
	}
	
	
	
	
	
	
}
