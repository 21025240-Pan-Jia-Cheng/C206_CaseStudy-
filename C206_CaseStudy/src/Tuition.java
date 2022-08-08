import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tuition {
	
	private int registrationNo;
	private String tuitionID;
	private String email;
	private boolean status;
	private LocalDate registrationDateTime;
	
	public Tuition(int registrationNo, String tuitionID, String email) {
		this.registrationNo = registrationNo;
		this.tuitionID = tuitionID;
		this.email = email;
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
	public String toString() {
		
		
		String registrationInfo = String.format("%-20d %-20s %-30s %-20s %-20s", 
				registrationNo,
				tuitionID,
				email,
				showVacancy(status),
				registrationDateTime);
		return registrationInfo;
	}
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDate getRegistrationDateTime() {
		return registrationDateTime;
	}

	public void setRegistrationDateTime(LocalDate registrationDateTime) {
		this.registrationDateTime = registrationDateTime;
	}

	public int getRegistrationNo() {
		return registrationNo;
	}

	public String getTuitionID() {
		return tuitionID;
	}

	public String getEmail() {
		return email;
	}
	
	
	
	
}
