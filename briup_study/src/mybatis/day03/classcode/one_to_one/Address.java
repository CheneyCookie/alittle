package mybatis.day03.classcode.one_to_one;


public class Address {
	private Integer addrId;
	private String street;
	private String city;
	private String country;

	public Address() {
	}

	public Address(Integer id, String street, String city, String country) {
		this.street = street;
		this.city = city;
		this.country = country;
	}

	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", street=" + street + ", city="
				+ city + ", country=" + country + "]";
	}


}
