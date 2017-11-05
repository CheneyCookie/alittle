package com.cheney.bean;

public class Location {

	private Integer locationId;
	private String city;

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Location(Integer locationId, String city) {
		super();
		this.locationId = locationId;
		this.city = city;
	}

	public Location() {
		super();
	}

}
