
public class timetable {
//By 21021888- Koh Wee Ren
	private String id;
	private double price;
	private String startdate;
	private String enddate;
	private String mode;
	
	public timetable(String id, double price, String startdate, String enddate, String mode) {
		this.id = id;
		this.price = price;
		this.startdate = startdate;
		this.enddate = enddate;
		this.mode = mode;
	}
	
	public String getId() {
		return id;
	}

	public String toString() {
		String itemInfo = String.format("%-10s %-10.2f %-20s %-20s %-20s", 
				id,price,startdate,enddate,mode);
		return itemInfo;
	}
}
