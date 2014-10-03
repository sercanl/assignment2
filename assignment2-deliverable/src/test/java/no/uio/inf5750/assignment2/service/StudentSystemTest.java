package no.uio.inf5750.assignment2.service;

import static org.junit.Assert.*;

import org.junit.Test;
import no.uio.inf5750.assignment2.service.impl.DefaultStudentSystem;

public class StudentSystemTest {

	DefaultStudentSystem studentSystem = new DefaultStudentSystem();
	@Test
	public void testAddCourse() {
		
		studentSystem.addCourse("INF5750", "Open Source");
		studentSystem.addCourse("INF5181", "Process Improvement");
	}

	@Test
	public void testUpdateCourse() {
		
		studentSystem.updateCourse(5, "INF5750", "Open Source Development");
	}

	@Test
	public void testGetCourse() {
		studentSystem.getCourse(5);
	}

	@Test
	public void testGetCourseByCourseCode() {
		
		studentSystem.getCourseByCourseCode("INF5750");
	}

	@Test
	public void testGetCourseByName() {
		studentSystem.getCourseByName("Open Source Development");
	}

	@Test
	public void testGetAllCourses() {
		studentSystem.getAllCourses();
	}

	@Test
	public void testDelCourse() {
		studentSystem.delCourse(5);
	}

	@Test
	public void testAddAttendantToCourse() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveAttendantFromCourse() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddDegree() {
		studentSystem.addDegree("New Type");
	}

	@Test
	public void testUpdateDegree() {
		studentSystem.updateDegree(1, "Old Type");
	}

	@Test
	public void testGetDegree() {
		studentSystem.getDegree(1);
	}

	@Test
	public void testGetDegreeByType() {
		studentSystem.getDegreeByType("Old Type");
	}

	@Test
	public void testGetAllDegrees() {
		studentSystem.getAllDegrees();
	}

	@Test
	public void testDelDegree() {
		studentSystem.delDegree(1);
	}

	@Test
	public void testAddRequiredCourseToDegree() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveRequiredCourseFromDegree() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddStudent() {
		studentSystem.addStudent("Murat");
	}

	@Test
	public void testUpdateStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStudent() {
		studentSystem.getStudent(1);
	}

	@Test
	public void testGetStudentByName() {
		studentSystem.getStudentByName("Murat");
	}

	@Test
	public void testGetAllStudents() {
		studentSystem.getAllStudents();
	}

	@Test
	public void testDelStudent() {
		studentSystem.delStudent(1);
	}

	@Test
	public void testAddDegreeToStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveDegreeFromStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testStudentFulfillsDegreeRequirements() {
		fail("Not yet implemented");
	}

}
