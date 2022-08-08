public class TuitionClass {

	private String tuitionCode;
	private String tuitionTitle;
	private String subjectGroup;
	private String description;
	private String duration;
	private boolean preRequisite;
	private String teacherInfo;

	public TuitionClass(String tuitionCode, String tuitionTitle, String subjectGroup, String description, String duration,
			boolean preRequisite, String teacherInfo) {
		this.tuitionCode = tuitionCode;
		this.tuitionTitle = tuitionTitle;
		this.subjectGroup = subjectGroup;
		this.description = description;
		this.duration = duration;
		this.preRequisite = preRequisite;
		this.teacherInfo = teacherInfo;
	}

	public String getTuitionCode() {
		return tuitionCode;
	}

	public String getTuitionTitle() {
		return tuitionTitle;
	}

	public String getSubjectGroup() {
		return subjectGroup;
	}

	public String getDescription() {
		return description;
	}

	public String getDuration() {
		return duration;
	}

	public boolean isPreRequisite() {
		return preRequisite;
	}

	public String getTeacherInfo() {
		return teacherInfo;
	}

	@Override
	public String toString() {
		String itemInfo = String.format("%-20s %-20s %-20s %-50s %-20s %-20s %-10s",
				tuitionCode, tuitionTitle, subjectGroup, description, duration,
				preRequisite, teacherInfo) ;
		return itemInfo;
	}



}


