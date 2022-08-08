//TRICIA WONG
/**
 * 
 */

/**
 * @author 21008790
 *
 */
public class details {

	private String name;
	private String gender;
	private String mobile ;
	private String email;
	private String dateofBirth;
	private String country;
	private String interest;


		public details(String name, String gender, String mobile, String email, String dateofBirth, String country, String interest ) {
			this.name = name;
			this.gender = gender;
			this.mobile = mobile;
			this.email = email;
			this.dateofBirth = dateofBirth;
			this.country =  country;
			this.interest = interest;
		}


		public String getName() {
			return name;
		}


		public String getGender() {
			return gender;
		}


		public String getMobile() {
			return mobile;
		}


		public String getEmail() {
			return email;
		}


		public String getDateofBirth() {
			return dateofBirth;
		}


		public String getCountry() {
			return country;
		}


		public String getInterest() {
			return interest;
		}
}
