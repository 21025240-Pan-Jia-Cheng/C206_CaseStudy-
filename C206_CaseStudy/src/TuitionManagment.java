/**
 * 
 */

/**
 * @author 21008790
 *
 */
import java.util.ArrayList;
public class TuitionManagment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("Tricia", "female", "92235939", "triciawong19@gmail.com", "03/11/2002", "singapore",
				"shopping"));
		studentList.add(new Student("Aricia", "female", "92202937", "ariciawong04@gmail.com", "11/01/2002", "singapore",
				"running"));
		studentList.add(new Student("Tommy", "male", "97332937", "tommy@gmail.com", "04/01/2002", "singapore",
				"running"));
		
		
		int option = 0;

		while (option != 4) {

			TuitionManagment.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				TuitionManagment.viewAllStudent(studentList);
			

			} else if (option == 2) {
				// Add student
				TuitionManagment.setHeader("ADD");			
				TuitionManagment.setHeader("DETAILS");
				System.out.println("1. Student");

				
				int details = Helper.readInt("Enter option to select item type > ");

				if (details == 1) {
					// Add student
					Student stu = inputdetails();
					TuitionManagment.addStudent(studentList, stu );
					System.out.println("Student added");

				} else {
					System.out.println("Invalid details");
				}

			} else if (option == 3) {
				// delete student
				TuitionManagment.setHeader("DELETE");			
				TuitionManagment.setHeader("DELETE STUDENTS");
				System.out.println("1. student");
		
				int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// delete students
					TuitionManagment.deletestudent(studentList);
		
				} else {
					System.out.println("Invalid type");
				}

			
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		TuitionManagment.setHeader("TUTION MANAGMENT");
		System.out.println("1. Display Students");
		System.out.println("2. Add Students");
		System.out.println("3. Delete Students");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(130, "-");
		System.out.println(header);
		Helper.line(130, "-");
	}

//======================================= Option 1 View students =================================
	public static String retrieveAllstudent(ArrayList<Student> studentList) {
		String output = "";

		for (int i = 0; i < studentList.size(); i++) {

			output += String.format("%-10s %-10s %-10s %-30s %-20s %-20s %-20s\n", studentList.get(i).getName(),
					studentList.get(i).getGender(),
					studentList.get(i).getMobile(),
					studentList.get(i).getEmail(),
					studentList.get(i).getDateofBirth(),
					studentList.get(i).getCountry(),
					studentList.get(i).getInterest());
		}
		return output;
	}
	public static void viewAllStudent(ArrayList<Student> studentList) {
		TuitionManagment.setHeader("STUDENT LIST");
		String output = String.format("%-10s %-10s %-10s %-30s %-20s %-20s %-20s\n", "NAME", "GENDER",
				"MOBILE", "EMAIL","DATE OF BIRTH", "COUNTRY", "INTEREST");
		 output += retrieveAllstudent(studentList);	
		System.out.println(output);
	}

	//================================= Option 2 Add an item (CRUD - Create) =================================
	public static Student inputdetails() {
		String name = Helper.readString("Enter your name > ");
		String gender = Helper.readString("Enter your gender > ");
		String mobile = Helper.readString("Enter your mobile number > ");
		String email = Helper.readString("Enter your email > ");
		String dateofBirth = Helper.readString("Enter your birthday > ");
		String country = Helper.readString("Enter your country residence > ");
		String interest = Helper.readString("Enter your interest > ");
		
		 Student stu= new Student(name, gender, mobile, email, dateofBirth, country, interest);
		return stu;
		
	}
	public static void addStudent(ArrayList<Student> studentList, Student stu) {
		
		studentList.add(stu);
	}
	
	//================================= Option 3 delete students (CRUD - Update) =================================
		public static boolean deletestudent(ArrayList<Student> studentList) {
			
			boolean isDeleted = false;
			String email = Helper.readString("Enter your email > ");
			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i).getEmail().contentEquals(email)) {
					studentList.remove(i);
				}
					
					isDeleted = true;
					
				}
			return isDeleted;
		}
}