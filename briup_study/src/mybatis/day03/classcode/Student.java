package mybatis.day03.classcode;

import java.util.Date;

public class Student {
	private Integer id;
	private String name;
	private String email;
	private Date dob;
	private PhoneNumber phone;

	public Student() {
	}

	public Student(String name, String email, Date dob, PhoneNumber phone) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
	}

	public Student(Integer id, String name, String email, Date dob,
			PhoneNumber phone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public PhoneNumber getPhone() {
		return phone;
	}

	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email
				+ ", dob=" + dob + ", phone=" + phone + "]";
	}

}
