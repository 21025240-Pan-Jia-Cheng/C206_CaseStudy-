import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TuitionManagement {

	private static final int OPTION_DELETE = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_QUIT = 4;
//Wee Ren
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList<Tuition> registrationList = new ArrayList<Tuition>();
		ArrayList<timetable> timetableList = new ArrayList<timetable>();
		int option = 0;
		 
		while (option != 4) { 

			TuitionManagement.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				TuitionManagement.viewAlltimetable(timetableList);
			} else if (option == 2) {
				timetable tt = inputtimetable();
				TuitionManagement.addtimetable(timetableList, tt);
			} else if (option == 3) {
				String dt = Helper.readString("Enter the tuition timetable id that you want to delete > ");
				TuitionManagement.deletetimetable(timetableList,dt);
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}
		}
/*		while (option != OPTION_QUIT) {
			TuitionManagement.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == OPTION_VIEW) {
				TuitionManagement.viewAllRegistration(registrationList);
				
			} else if (option == OPTION_ADD) {
				Helper.line(50, "-");
				System.out.println("TUITION REGISTRATION");
				Helper.line(50, "-");
				Tuition t = inputRegistration();
				TuitionManagement.registerTuition(registrationList, t);
				System.out.println("Successfully Registered a Tuition!");
				
			} else if (option == OPTION_DELETE) {
				TuitionManagement.deleteRegistration(registrationList);
			} else if (option == OPTION_QUIT) {
				System.out.println("Thank you for registering in the tuition management system! =)");
			} else {
				System.out.println("Invalid option!");
			}
		}
		
	}
	
	public static void menu() {
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
		
	}*/
	
	public static void menu() {
		TuitionManagement.setHeader("TUITION APP");
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
	TuitionManagement.setHeader("TIMETABLE LIST");
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
}


