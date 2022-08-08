import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TuitionManagement {

	private static final int OPTION_DELETE = 3;
	private static final int OPTION_ADD = 2;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_QUIT = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Tuition> registrationList = new ArrayList<Tuition>();
		
		int option = 0;
		
		while (option != OPTION_QUIT) {
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
		
	}

}
