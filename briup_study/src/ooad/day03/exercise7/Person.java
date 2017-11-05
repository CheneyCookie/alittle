package ooad.day03.exercise7;

public class Person {
	private String status;
	private String direct;

	public Person() {
		super();
		status="live";
		direct="north";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	@Override
	public String toString() {
		return "Person [status=" + status + "]";
	}
	
	public void turn(String turnDirect){
		if(turnDirect.equals("left")){
			if(direct.equals("north")){
				setDirect("west");
			}else if(direct.equals("west")){
				setDirect("south");
			}else if(direct.equals("south")){
				setDirect("east");
			}else if(direct.equals("east")){
				setDirect("north");
			}
		}else if(turnDirect.equals("right")){
			if(direct.equals("north")){
				setDirect("east");
			}else if(direct.equals("east")){
				setDirect("south");
			}else if(direct.equals("south")){
				setDirect("west");
			}else if(direct.equals("west")){
				setDirect("north");
			}
		}
	}
	
}
