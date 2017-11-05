package mybatis.day04;

import java.util.Date;

public class Course {
	private Integer id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private Tutor tutor;

	public Course() {
	}

	public Course(Integer id, String name, String description, Date start_date,
			Date end_date, Tutor tutor) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.startDate = start_date;
		this.endDate = end_date;
		this.tutor = tutor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart_date() {
		return startDate;
	}

	public void setStart_date(Date start_date) {
		this.startDate = start_date;
	}

	public Date getEnd_date() {
		return endDate;
	}

	public void setEnd_date(Date end_date) {
		this.endDate = end_date;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", description="
				+ description + ", start_date=" + startDate + ", end_date="
				+ endDate + ", tutor=" + tutor + "]";
	}

}
