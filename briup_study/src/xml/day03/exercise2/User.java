package xml.day03.exercise2;

/**
 * User的bean类
 * 
 * @author cheney
 *
 */
public class User {
	private String name;
	private Double cost;

	public User() {
	}

	public User(String name, Double cost) {
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", cost=" + cost + "]";
	}

}
