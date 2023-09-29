package manytomanybie2.Controller;

import manytomanybie2.dao.CoursesDao;
import manytomanybie2.dao.StudentDao;
import manytomanybie2.dto.Courses;
import manytomanybie2.dto.Student;

public class MainCont {
public static void main(String[] args) {
	CoursesDao coursesDao=new CoursesDao();
	Courses courses=new Courses();
	courses.setName("corejava");
	courses.setFees(6000);
	
//	coursesDao.updateCourses(1, courses);

	
	StudentDao dao=new StudentDao();
//	Student student=new Student();
//	student.setName("Manimegalai");
//	student.setAdress("banagalore");
//	dao.updateStudent(1, student);
//	
//	DeleteOperation
//	dao.deleteStudent(1);
	coursesDao.deleteCourses(1);
	
}
}
