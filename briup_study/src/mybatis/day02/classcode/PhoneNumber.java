package mybatis.day02.classcode;

public class PhoneNumber {
	private String countryCode;
	private String stateCode;
	private String number;

	public PhoneNumber(String str) {
		// 将从数据库查询的结果，拿当前对象接收
		if (str != null) {
			String[] phone = str.split("-");
			countryCode = phone[0];
			stateCode = phone[1];
			number = phone[2];
		}
	}

	public String getAsString() {
		return countryCode + "-" + stateCode + "-" + number;
	}

	public PhoneNumber() {
	}

	public PhoneNumber(String countryCode, String stateCode, String number) {
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.number = number;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "PhoneNumber [countryCode=" + countryCode + ", stateCode="
				+ stateCode + ", number=" + number + "]";
	}

}
