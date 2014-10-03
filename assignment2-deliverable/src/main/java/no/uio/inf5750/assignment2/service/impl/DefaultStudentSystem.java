package no.uio.inf5750.assignment2.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import no.uio.inf5750.assignment2.dao.CourseDAO;
import no.uio.inf5750.assignment2.dao.DegreeDAO;
import no.uio.inf5750.assignment2.dao.StudentDAO;
import no.uio.inf5750.assignment2.model.Course;
import no.uio.inf5750.assignment2.model.Degree;
import no.uio.inf5750.assignment2.model.Student;
import no.uio.inf5750.assignment2.service.StudentSystem;

public class DefaultStudentSystem implements StudentSystem {
	
	@Autowired
	private CourseDAO courseDAO;
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private DegreeDAO degreeDAO;
	
	@Override
	public int addCourse(String courseCode, String name) {
		
		Course newCourse = new Course(courseCode, name);
		return courseDAO.saveCourse(newCourse);
	}

	@Override
	public void updateCourse(int courseId, String courseCode, String name) {
		
		delCourse(courseId);
		addCourse(courseCode, name);
	}

	@Override
	public Course getCourse(int courseId) {
		
		return courseDAO.getCourse(courseId);
	}

	@Override
	public Course getCourseByCourseCode(String courseCode) {
		
		return courseDAO.getCourseByCourseCode(courseCode);
	}

	@Override
	public Course getCourseByName(String name) {
		
		return courseDAO.getCourseByName(name);
	}

	@Override
	public Collection<Course> getAllCourses() {
		
		return courseDAO.getAllCourses();
	}

	@Override
	public void delCourse(int courseId) {
		
		courseDAO.delCourse(getCourse(courseId));
	}

	@Override
	public void addAttendantToCourse(int courseId, int studentId) {
		
		//Student student = new Student(studentDAO.getStudent(studentId).getName());
		//student.setCourses();
		// setAttendants() ?
	}

	@Override
	public void removeAttendantFromCourse(int courseId, int studentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addDegree(String type) {
		Degree degree = new Degree(type);
		return degreeDAO.saveDegree(degree);
	}

	@Override
	public void updateDegree(int degreeId, String type) {
		
		delDegree(degreeId);
		addDegree(type);
	}

	@Override
	public Degree getDegree(int degreeId) {
		
		return degreeDAO.getDegree(degreeId);
	}

	@Override
	public Degree getDegreeByType(String type) {
		
		return degreeDAO.getDegreeByType(type);
	}

	@Override
	public Collection<Degree> getAllDegrees() {
		
		return degreeDAO.getAllDegrees();
	}

	@Override
	public void delDegree(int degreeId) {
		
		degreeDAO.delDegree(getDegree(degreeId));
	}

	@Override
	public void addRequiredCourseToDegree(int degreeId, int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRequiredCourseFromDegree(int degreeId, int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int addStudent(String name) {
		
		Student student = new Student(name);
		return studentDAO.saveStudent(student);
	}

	@Override
	public void updateStudent(int studentId, String name) {
		
		delStudent(studentId);
		addStudent(name);
	}

	@Override
	public Student getStudent(int studentId) {
		
		return studentDAO.getStudent(studentId);
	}

	@Override
	public Student getStudentByName(String name) {
		
		return studentDAO.getStudentByName(name);
	}

	@Override
	public Collection<Student> getAllStudents() {
		
		return studentDAO.getAllStudents();
	}

	@Override
	public void delStudent(int studentId) {
		
		studentDAO.delStudent(getStudent(studentId));
	}

	@Override
	public void addDegreeToStudent(int studentId, int degreeId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeDegreeFromStudent(int studentId, int degreeId) {
		
	}

	@Override
	public boolean studentFulfillsDegreeRequirements(int studentId, int degreeId) {
		
		Degree degree = degreeDAO.getDegree(degreeId);
		Student student = studentDAO.getStudent(studentId);
		
		if (degree.getRequiredCourses().equals(student.getCourses())) {
			return true;
		}
		else {
			return false;
		}
	}
}
