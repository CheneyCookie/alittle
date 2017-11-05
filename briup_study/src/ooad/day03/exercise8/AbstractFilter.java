package ooad.day03.exercise8;

public abstract class AbstractFilter implements Filter{
	
	private String name;
	private Filter filter;
	public AbstractFilter(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Filter getFilter() {
		return filter;
	}
	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	
}
