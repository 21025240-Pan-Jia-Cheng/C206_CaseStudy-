import java.util.ArrayList;
//By 21021888- Koh Wee Ren
public class TuitionManagment {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int option = 0;
	
	ArrayList<timetable> timetableList = new ArrayList<timetable>();
	while (option != 4) { 

		TuitionManagment.menu();
		option = Helper.readInt("Enter an option > ");

		if (option == 1) {
			TuitionManagment.viewAlltimetable(timetableList);
		} else if (option == 2) {
			timetable tt = inputtimetable();
			TuitionManagment.addtimetable(timetableList, tt);
		} else if (option == 3) {
			String dt = Helper.readString("Enter the tuition timetable id that you want to delete > ");
			TuitionManagment.deletetimetable(timetableList,dt);
		} else if (option == 4) {
			System.out.println("Bye!");
		} else {
			System.out.println("Invalid option");
		}

	}
	}
	public static void menu() {
		TuitionManagment.setHeader("TUITION APP");
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
	TuitionManagment.setHeader("TIMETABLE LIST");
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