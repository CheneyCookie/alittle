package ooad.day01.exercise4.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShopCar {
	
	private Integer id;
	private List<Goods> goodses;
	private BigDecimal total;
	private User user;
	private static int i;
	
	public ShopCar() {
		i=1;
		id = i;
		goodses=new ArrayList<Goods>();
		i++;
	}
	
	public ShopCar(User user) {
		i=1;
		id = i;
		goodses=new ArrayList<Goods>();
		this.user=user;
		i++;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Goods> getGoodses() {
		return goodses;
	}

	public void setGoodses(List<Goods> goodses) {
		this.goodses = goodses;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ShopCar [id=" + id + ", goodses=" + goodses + ", total="
				+ total + ", user=" + user + "]";
	}

	
}
