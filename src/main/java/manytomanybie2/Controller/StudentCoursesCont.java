package manytomanybie2.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomanybie2.dto.Courses;
import manytomanybie2.dto.Student;

public class StudentCoursesCont {
public static void main(String[] args) {
	Student student1=new Student();
	student1.setName("mani");
	student1.setId(1);
	student1.setAdress("Chennai");
	
	Student student2=new Student();
	student2.setName("jagadish");
	student2.setId(2);
	student2.setAdress("bangalore");
	
	Student student3=new Student();
	student3.setName("ahmad");
	student3.setId(3);
	student3.setAdress("delhi");
	
	Courses courses1=new Courses();
	courses1.setId(1);
	courses1.setName("java");
	courses1.setFees(6000);

	Courses courses2=new Courses();
	courses2.setId(2);
	courses2.setName("advjava");
	courses2.setFees(10000);
	
	Courses courses3=new Courses();
	courses3.setId(3);
	courses3.setName("sql");
	courses3.setFees(15000);
	
	
	List<Courses> coursesOfMani=new ArrayList<Courses>();
	coursesOfMani.add(courses1);
	coursesOfMani.add(courses2);
	coursesOfMani.add(courses3);
	
	student1.setCourses(coursesOfMani);
	student2.setCourses(coursesOfMani);
	student3.setCourses(coursesOfMani);
	
	List<Student> students=new ArrayList<Student>();
	students.add(student1);
	students.add(student2);
	students.add(student3);
	
	courses1.setStudents(students);
	courses2.setStudents(students);
	courses3.setStudents(students);
	
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(courses1);
	entityManager.persist(courses2);
	entityManager.persist(courses3);
	entityManager.persist(student1);
	entityManager.persist(student2);
	entityManager.persist(student3);
	entityTransaction.commit();
	
	
	
	
}
}
