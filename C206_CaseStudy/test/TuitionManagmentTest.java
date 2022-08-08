//TRICIA
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TuitionManagmentTest {
	// prepare test data
	private Student stu1;
	private Student stu2;
	private Student stu3;

	private ArrayList<Student> studentList;

	public TuitionManagmentTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		// prepare test data
		stu1 = new Student("Tricia", "female", "92235939", "triciawong19@gmail.com", "03/11/2002", "singapore",
				"shopping");
		stu2 = new Student("Aricia", "female", "92202937", "ariciawong04@gmail.com", "11/01/2002", "singapore",
				"running");
		stu3 = (new Student("Tommy", "male", "97332937", "tommy@gmail.com", "04/01/2002", "singapore", "running"));

		studentList = new ArrayList<Student>();
	}

	@Test
	public void testAddStudent() {

		// TEST-CONDITION: BOUNDARY
		// TEST-CASE: Test that the student list is not null, so that a new student can
		// be added to.
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);

		// TEST-CONDITION: NORMAL
		// TEST-CASE: Test that given an empty student list, after adding one student,
		// the size of the student list is 1
		TuitionManagment.addStudent(studentList, stu1);
		assertEquals("Test if that student arraylist size is 1 ?", 1, studentList.size());

		// TEST-CONDITION: NORMAL
		// TEST-CASE: Test if the detail just added is as same as the first details of
		// the student list.
		assertSame("Test that student details is added same as 1st detail of the list?", stu1, studentList.get(0));

		// TEST-CONDITION: NORMAL
		// TEST-CASE: Test that adds another item
		// - the size of the student list is 2
		// - the student just added is as same as the 2nd student of the student list.
		TuitionManagment.addStudent(studentList, stu2);
		assertEquals("Test that Student arraylist size is 2?", 2, studentList.size());
		assertSame("Test that Student is added same as 2nd item of the list?", stu2, studentList.get(1));
	}

	@Test
	public void testRetrieveAllStudent() {

		// TEST-CONDITION: BOUNDARY
		// TEST-CASE: Test that the student list is not null, so that there are registered student accounts to view. 
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);

		// TEST-CONDITION: NORMAL
		// TEST-CASE: test if the list of students retrieved from the TuitionManagment
		// is empty
		String allStudent = TuitionManagment.retrieveAllstudent(studentList);
		String testOutput = "";
		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);

		// TEST-CONDITION: NORMAL
		// TEST-CASE: Test that given an empty list, after adding 3 student details, test if the
		// size of the student list is 3.
		TuitionManagment.addStudent(studentList, stu1);
		TuitionManagment.addStudent(studentList, stu2);
		TuitionManagment.addStudent(studentList, stu3);

		assertEquals("Test if that Student arraylist size is 3?", 3, studentList.size());

		// TEST-CONDITION: NORMAL
		// TEST-CASE: Test if the expected output string same as the list of students
		// retrieved from the TuitionManagment.
		// from the tuitionManagment
		allStudent = TuitionManagment.retrieveAllstudent(studentList);

		testOutput = String.format("%-10s %-10s %-10s %-30s %-20s %-20s %-20s\n", "Tricia", "female", "92235939",
				"triciawong19@gmail.com", "03/11/2002", "singapore", "shopping");
		testOutput += String.format("%-10s %-10s %-10s %-30s %-20s %-20s %-20s\n", "Aricia", "female", "92202937",
				"ariciawong04@gmail.com", "11/01/2002", "singapore", "running");
		testOutput += String.format("%-10s %-10s %-10s %-30s %-20s %-20s %-20s\n", "Tommy", "male", "97332937",
				"tommy@gmail.com", "04/01/2002", "singapore", "running");

		assertEquals("Check that ViewAllStudentlist", testOutput, allStudent);
	}

	@Test
	public void testdeletestudent() {
		// TEST-CONDITION: BOUNDARY
		// TEST-CASE: Test that the student list is not null, so that registered student can be deleted. 
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);
		TuitionManagment.addStudent(studentList, stu1);

		// TEST-CONDITION: ERROR
		// TEST-CASE: Test if registered student account stu1 is deleted.
		//Tuition administrator delete student account that is registered in
		// the system can put any email expect this triciawong19@gmail.com
		Boolean isDeleted = TuitionManagment.deletestudent(studentList);
		assertFalse("Test if registered student \"triciawong19@gmail.com\" is deleted -false?", isDeleted);

		// TEST-CONDITION: NORMAL
		// TEST-CASE: Test if registered student account with ariciawong04@gmail.com is deleted.
		//Tuition administrator delete student account that is registered in the system.
		TuitionManagment.addStudent(studentList, stu2);
		stu2.getEmail();
		isDeleted = TuitionManagment.deletestudent(studentList);
		assertTrue("Test if ariciawong04@gmail.com is deleted- true", isDeleted);

		// TEST-CONDITION: ERROR
		// TEST-CASE:Test if non-existing student account with the email issac@gmail.com
		// is deleted.
		// Tuition administrator delete student account that is not registered in the
		// system.
		isDeleted = TuitionManagment.deletestudent(studentList);
		assertFalse("Test if non-existing student issac@gmail.com is deleted- false?", isDeleted);

	}

	@After
	public void tearDown() throws Exception {
		stu1 = null;
		stu2 = null;
		stu3 = null;

		studentList = null;
	}

}