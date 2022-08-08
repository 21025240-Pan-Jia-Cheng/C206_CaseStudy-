import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//By 21021888- Koh Wee Ren
public class C206_CaseStudyTest {
	// prepare test data
	private timetable tt1;
	private timetable tt2;
	private timetable tt3;
	private static final String idpattern = "[T]\\d{3}";
	private ArrayList<timetable> timetableList;
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		tt1 = new timetable("T001", 1234.00,"13/07/2015", "17/10/2019", "HBL");
		tt2 = new timetable("T002", 1560.00, "16/11/2016", "14/12/2020", "F2F");
		tt3 = new timetable("T003", 1789.00,"18/09/2017", "25/11/2021", "HBL");
		timetableList= new ArrayList<timetable>();

	}
	
	@Test
	public void testaddtimetable() {
		//Boundary - checking if the timetableList is empty
		assertNotNull("Test if there is valid timetable in the arraylist", timetableList);
	
		//Normal
		//Check if timetable is added in the list
		TuitionManagement.addtimetable(timetableList, tt1);		
		assertEquals("Test if that timetable arraylist size is 1?", 1, timetableList.size());
		
		//Boundary - tuition id must be unique
		Boolean successAdd = TuitionManagement.addtimetable(timetableList, tt1);
		assertFalse(successAdd);
		
		//Boundary - Check if Id input is correct based on the pattern of T + 3 digit
		boolean matched = Pattern.matches(idpattern, tt1.getId());
		assertTrue(matched);

	}
	@Test
	public void testretrievetimetable() {
		//Test if timetableList is empty
		String viewAlltimetable = TuitionManagement.retrieveAlltimetable(timetableList);;
		String testOutput = "";
		assertEquals("Check that ViewviewAlltimetableList", testOutput, viewAlltimetable);
			
		//Normal - check if total of 2 element is retrieved
		TuitionManagement.addtimetable(timetableList, tt2);
		TuitionManagement.addtimetable(timetableList, tt3);
		assertEquals("Test if that timetable arraylist size is 2?", 2, timetableList.size());
		
		//Normal -test if retrieve output from main is the same as the expected
		viewAlltimetable= TuitionManagement.retrieveAlltimetable(timetableList);
		testOutput += String.format("%-10s %-10.2f %-20s %-20s %-20s\n","T002", 1560.00,"16/11/2016", "14/12/2020", "F2F");
		testOutput += String.format("%-10s %-10.2f %-20s %-20s %-20s\n","T003", 1789.00,"18/09/2017", "25/11/2021", "HBL");
		assertEquals("Check that ViewviewAlltimetableList", testOutput , viewAlltimetable);
	}
	@Test
	public void testdeletetimetable() {
		//boundary - Test if Item list is not null but empty
		assertNotNull("Test if there is valid timetable arraylist to delete", timetableList);
		//Normal - tuition timetable with id "T001" is deleted 
		TuitionManagement.addtimetable(timetableList, tt1);
		Boolean isdeleted = TuitionManagement.deletetimetable(timetableList,"T001");
		assertTrue(isdeleted);
	
		//Error - Test that non-existing item cannot be delete
		isdeleted =TuitionManagement.deletetimetable(timetableList, "T002");
		assertFalse(isdeleted);
	}
	@After
	public void tearDown() throws Exception {
		tt1 = null;
		tt2 = null;
		tt3 = null;
		timetableList = null;
	}
}
