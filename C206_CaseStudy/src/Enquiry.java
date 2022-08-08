
public class Enquiry {
	private int enquiry_id;
	private String title;
	private String date;
	private String method;
	private String time;
	private String status;
	
	
	//Done by Jia Cheng
	public Enquiry(int enquiry_id, String title, String date , String method, String time , String status) {
		this.enquiry_id = enquiry_id;
		this.title = title;
		this.date = date;
		this.method = method;
		this.time = time;
		this.status = status;
	}
	public int getEnquiry_id() {
		return enquiry_id;
	}
	public String getTitle() {
		return title;
	}
	public String getDate() {
		return date;
	}
	public String getMethod() {
		return method;
	}
	public String getTime() {
		return time;
	}
	public String getStatus() {
		return status;
	}
	
	
	

}
