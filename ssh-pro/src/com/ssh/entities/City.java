package com.ssh.entities;

public class City {
	private Integer id;
	private String city_name;
	private Province province;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public Province getProvince() {
		return province;
	}
	public void setProvince(Province province) {
		this.province = province;
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", city_name=" + city_name + ", province="
				+ province + "]";
	}
	
}
