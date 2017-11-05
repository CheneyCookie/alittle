package ooad.day01.exercise4.bean;

import java.math.BigDecimal;

public class Goods {
	
	private int code;
	private String name;
	private BigDecimal price;
	private Integer number;
	
	
	public Goods(int code, String name, BigDecimal price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		number=1;
	}
	
	public Goods(int code, String name, BigDecimal price,Integer number) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.number=number;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Goods [code=" + code + ", name=" + name + ", price=" + price
				+ ", number=" + number + "]";
	}
	
}
