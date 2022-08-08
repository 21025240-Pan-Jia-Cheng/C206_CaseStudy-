import java.time.LocalDate;
import java.util.ArrayList;

public class C206_CaseStudy {
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		int call = 0;
		C206_CaseStudy.mainmenu();
		call = Helper.readInt("Enter menu to call > ");
		
	if (call == 1) {
		//Start -H
		ArrayList<Tuition> registrationList = new ArrayList<Tuition>();
		
		int option = 0;
		
		while (option != OPTION_QUIT) {
			C206_CaseStudy.menu1();
			option = Helper.readInt("Enter an option > ");
			
			if (option == OPTION_VIEW) {
				C206_CaseStudy.viewAllRegistration(registrationList);
			} else if (option == OPTION_ADD) {
				Helper.line(50, "-");
				System.out.println("TUITION REGISTRATION");
				Helper.line(50, "-");
				Tuition t = inputRegistration();
				C206_CaseStudy.registerTuition(registrationList, t);
				System.out.println("Successfully Registered a Tuition!");
				
			} else if (option == OPTION_DELETE) {
				C206_CaseStudy.deleteRegistration(registrationList);
			} else if (option == OPTION_QUIT) {
				System.out.println("Thank you for registering in the tuition management system! =)");
			} else {
				System.out.println("Invalid option!");
			}
		}
	}
	//===============================================By Wee Ren===============================================================================>>
	else if (call == 2) {
	int option = 0;
	ArrayList<timetable> timetableList = new ArrayList<timetable>();
	while (option != OPTION_QUIT) { 
		
		C206_CaseStudy.menu2();
		option = Helper.readInt("Enter an option > ");

		if (option == OPTION_VIEW) {
			C206_CaseStudy.viewAlltimetable(timetableList);
		} else if (option == OPTION_ADD) {
			timetable tt = inputtimetable();
			C206_CaseStudy.addtimetable(timetableList, tt);
		} else if (option == OPTION_DELETE) {
			String dt = Helper.readString("Enter the tuition timetable id that you want to delete > ");
			C206_CaseStudy.deletetimetable(timetableList,dt);
		} else if (option == OPTION_QUIT) {
			System.out.println("Bye!");
		} else {
			System.out.println("Invalid option");
		}
		//=====================================================End - H=======================================================================
		}
	}
	else if (call == 3) {

		ArrayList<Enquiry> enquiryList = new ArrayList<Enquiry>();
		
		enquiryList.add(new Enquiry (1,"Availability of math tuition" , "2/8/2022", "By phone" , "11:11pm" , "Resolved"));
		enquiryList.add(new Enquiry (2,"English tution timetable" , "3/8/2022", "By email" , "11:59pm" , "Unresolved"));
		
		
		int option = 0;

		while (option != 4) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == 1) {
				// View all enquiry
				C206_CaseStudy.viewAllEnquiry(enquiryList);	
			} else if (option == 2) {
				// Add a new enquiry
				C206_CaseStudy.setHeader("ADD");
				Enquiry e = inputEnquiry();
				C206_CaseStudy.addEnquiry(enquiryList, e);
				System.out.println("Enquiry added");
				
			} else if (option == 3) { 
				int searchId = Helper.readInt("Enter enquiry id you want to delete > ");
				C206_CaseStudy.deleteEnquiry(enquiryList , searchId);
				System.out.println("Enquiry deleted");
				
				
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	}
	}
//=====================================================End by JC=======================================================================
	//BIG MENU
	public static void mainmenu() {
		C206_CaseStudy.setHeader("TUITION APP");
		System.out.println("1. Manage Tuition Timetable");
		System.out.println("2. Manage Tuition Registration");
		System.out.println("3. Manage Tuition Enquiry");
		System.out.println("4. Manage Tuition");
		System.out.println("5. Manage Student Details");
		System.out.println("6. Quit");
		Helper.line(80, "-");
	}
	//End of BIG MENU
	
	//Start of Wee Ren's Code
	public static void menu1() {
		C206_CaseStudy.setHeader("TUITION APP");
		System.out.println("1. View tuition timetable");
		System.out.println("2. Add tuition timetable");
		System.out.println("3. Delete tuition timetable");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
public static String retrieveAlltimetable(ArrayList<timetable> timetableList) {
		String output = "";

		for (int i = 0; i < timetableList.size(); i++) {

			output += String.format("%-84s\n", timetableList.get(i).toString()); 
		}
		return output;
	}
	
public static void viewAlltimetable(ArrayList<timetable> timetableList) {
	C206_CaseStudy.setHeader("TIMETABLE LIST");
	String output = String.format("%-10s %-10s %-20s %-20s %-20s\n", "ID", "PRICE",
			"START DATE", "END DATE","MODE");
	output += 	retrieveAlltimetable(timetableList);
	System.out.println(output);
	}

public static timetable inputtimetable() {
	timetable tt = null;
	String id = Helper.readString("Enter tuition timetable id > ");
	double price = Helper.readDouble("Enter the price > ");
	String startdate = Helper.readString("Enter the start date > ");
	String enddate = Helper.readString("Enter the end date > ");
	String mode = Helper.readString("Enter the mode type > ");
	tt = new timetable(id, price, startdate,enddate, mode);
	return tt;
	
}	
public static boolean addtimetable(ArrayList<timetable> timetableList, timetable tt) {
	boolean unique = true;
	for (timetable i : timetableList) {
		if (i.getId().contentEquals(tt.getId())) {
			System.out.println("Error! This tuition ID is duplicated");
			unique = false;
		}
	}
	if (unique == true){
		timetableList.add(tt);
		System.out.println("This tuition ID is now added");
	}
	return unique;
}

public static boolean deletetimetable(ArrayList<timetable> timetableList, String dt) {
	boolean deleted = false;
	for (int i = 0; i < timetableList.size(); i++) {
		String var = timetableList.get(i).getId();
		if (var.contentEquals(dt)){
			timetableList.remove(i);
			System.out.println("Tuition timetable with ID " + var + " was deleted");
			deleted = true;
			}
	}
	if (deleted == false) {
		System.out.println("Invalid timetable ID was input.");
		}
	return deleted;
}
//===============================================End By Wee Ren===============================================================================>>
//Start by Heather's code
public static void menu2() {
	Helper.line(50, "=");
	System.out.println("TUITION MANAGEMENT SYSTEM");
	Helper.line(50, "=");
	System.out.println("1. View all registrations");
	System.out.println("2. Register for a tuition");
	System.out.println("3. Cancel registration");
	System.out.println("4. Quit");
	Helper.line(50, "=");
}

public static String showVacancy(boolean status) {
	String avail;

	if (status == false) {
		avail = "Pending";
	} else {
		avail = "Vacant";
	}
	return avail;
}

public static String retrieveAllRegistration(ArrayList<Tuition> registrationList) {
	String output = "";

	for (int i = 0; i < registrationList.size(); i++) {


		output += String.format("%-84s\n", registrationList.get(i).toString());
	}
	return output;
}
public static void viewAllRegistration(ArrayList<Tuition> registrationList) {
	Helper.line(100, "-");
	System.out.println("REGISTRATION LIST");
	Helper.line(100, "-");
	String output = String.format("%-20s %-20s %-30s %-20s %-20s\n", "REGISTRATION NO", "TUITION ID",
			 "EMAIL", "STATUS","REGISTRATION DATE");
	 output += retrieveAllRegistration(registrationList);
	System.out.println(output);
}
public static Tuition inputRegistration() {
	int registrationNo = Helper.readInt("Enter registration no. > ");
	String tuitionID = Helper.readString("Enter tuitionID > ");
	String email = Helper.readString("Enter email > ");

	Tuition tt= new Tuition(registrationNo, tuitionID, email);
	return tt;
}
public static void registerTuition(ArrayList<Tuition> registrationList, Tuition tt) {
	registrationList.add(tt);
	for (int i = 0; i < registrationList.size(); i++) {
		registrationList.get(i).setRegistrationDateTime(LocalDate.now());
	}
}

public static void deleteRegistration(ArrayList<Tuition> registrationList) {
	
	int registrationNo = Helper.readInt("Enter registration no. >");
	
	boolean isDelete = false;
	
	for (int i = 0; i < registrationList.size(); i++) {
		if (registrationList.get(i).getRegistrationNo() == registrationNo) {
			registrationList.remove(registrationList.get(i));
			System.out.println("Registration no. " + registrationNo + " cancelled!");
			isDelete = true;
		}
	}
	if (isDelete == false) {
		System.out.println("Invalid Registration No.");
		
	}
}
//===============================================End By Heather===============================================================================>>

//Start -JC
public static void menu() {
	C206_CaseStudy.setHeader("Tuition Management System");
	System.out.println("1. View enquiry");
	System.out.println("2. Add enquiry");
	System.out.println("3. Delete enquiry");
	System.out.println("4. Quit");
	Helper.line(80, "-");

}


	
	//================================= Option 1 View items (CRUD- Read) =================================
	public static String retrieveAllEnquiry(ArrayList<Enquiry> enquiryList) {
		String output = "";

		for (int i = 0; i < enquiryList.size(); i++) {

			output += String.format("%-15d %-30s %-25s %-25s %-25s %-25s\n", enquiryList.get(i).getEnquiry_id(),
					enquiryList.get(i).getTitle(), enquiryList.get(i).getDate() , enquiryList.get(i).getMethod(),
					enquiryList.get(i).getTime() , enquiryList.get(i).getStatus());
		}
		return output;
	}
	public static void viewAllEnquiry(ArrayList<Enquiry> enquiryList) {
		C206_CaseStudy.setHeader("ENQUIRY LIST");
		String output = String.format("%-15s %-30s %-25s %-25s %-25s %-25s\n", "ENQUIRY ID", "TITLE", "DATE" , 
				"METHOD" , "TIME" , "STATUS");
		 output += retrieveAllEnquiry(enquiryList);	
		System.out.println(output);
	}

	//================================= Option 2 Add (CRUD - Create)=================================
	public static Enquiry inputEnquiry() {
		int id = Helper.readInt("Enter enquiry id > ");  
		String title = Helper.readString("Enter title > ");
		String date = Helper.readString("Enter date > ");
		String method = Helper.readString("Enter method > ");
		String time = Helper.readString("Enter time > ");
		String status = Helper.readString("Enter status > ");

		Enquiry e = new Enquiry(id, title, date , method , time , status);
		
		return e;
		
	}
	
	
	public static void addEnquiry(ArrayList<Enquiry> enquiryList, Enquiry e) {
		
		enquiryList.add(e);
		
	}
	public static boolean deleteEnquiry(ArrayList<Enquiry> enquiryList, int searchId ) {
		boolean doesDelete = false;
		
		
		for (int i = 0; i < enquiryList.size(); i++) { 
			int enquiryID = enquiryList.get(i).getEnquiry_id();
			   if (enquiryID == searchId) { 
				   enquiryList.remove(enquiryList.get(i)); 
			    System.out.println("Enquiry id " + searchId + " deleted!"); 
			    doesDelete = true; 
			   } 
			  } 
			  if (doesDelete == false) { 
			   System.out.println("Invalid enquiry id."); 
			  } 
			  return doesDelete;
	}
}
