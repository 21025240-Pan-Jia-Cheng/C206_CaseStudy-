import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TuitionManagementTest {
	private Tuition s1;
	private Tuition s2;
	private ArrayList<Tuition> registrationList;
	
	public TuitionManagementTest() {
		super();
	}

	@BeforeEach
	void setUp() throws Exception {
		s1 = new Tuition(1001, "M230", "amylee@gmail.com");
		s2 = new Tuition(1002, "M688", "amylee@gmail.com");
		registrationList= new ArrayList<Tuition>();
	}

	@Test
	public void testRegisterTuition() {
		//fail("Not yet implemented");
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid registration arraylist to add to", registrationList);
		                  
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		TuitionManagement.registerTuition(registrationList, s1);		
		assertEquals("Test that registration arraylist size is 1", 1, registrationList.size());
		assertSame("Test that registration is added", s1, registrationList.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		TuitionManagement.registerTuition(registrationList, s2);
		assertEquals("Test that registration arraylist size is 2", 2, registrationList.size());
		assertSame("Test that registration is added", s2, registrationList.get(1));
	}
	@Test
	public void testRetrieveAllRegistration() {
		//fail("Not yet implemented");
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid registration arraylist to retrieve item from", registrationList);
		
		//test if the list of registration retrieved from the TuitionManagement is empty - boundary
		String allRegistration= TuitionManagement.retrieveAllRegistration(registrationList);
		String testOutput = "";
		assertEquals("Test that the retrieved registrationList is empty?", testOutput, allRegistration);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		TuitionManagement.registerTuition(registrationList, s1);
		TuitionManagement.registerTuition(registrationList, s2);
		assertEquals("Test that registration arraylist size is 2", 2, registrationList.size());
		
		//test if the expected output string same as the list of registrations retrieved from the TuitionManagement	
		allRegistration= TuitionManagement.retrieveAllRegistration(registrationList);
		testOutput = String.format("%-20s %-20s %-30s %-20s %-20s\n","1001", "M230","amylee@gmail.com", "Pending", LocalDate.now());
		testOutput += String.format("%-20s %-20s %-30s %-20s %-20s\n","1002", "M688", "amylee@gmail.com", "Pending", LocalDate.now());	
		assertEquals("Test that ViewAllChromebooklist", testOutput, allRegistration);
}
    @Test
    public void testDeleteRegistration(){
    	//fail("Not yet implemented.");
         //Two registration added; one removed
         TuitionManagement.registerTuition(registrationList, s1);
         TuitionManagement.registerTuition(registrationList, s2);
         assertEquals("Test that registration arraylist size is 2", 2, registrationList.size());
         
         TuitionManagement.deleteRegistration(registrationList);
         assertEquals("Test that registration arraylist size is 1", 1,registrationList.size());
         
       boolean exists = false;
         
         for (Tuition t : registrationList) {
        	 if (t.getRegistrationNo() == s1.getRegistrationNo() | t.getRegistrationNo() == s2.getRegistrationNo()) 
        		 exists = true; 
        	 
        		 
         }
         assertTrue(exists);

    }
	@AfterEach
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		registrationList = null;

	}
}
