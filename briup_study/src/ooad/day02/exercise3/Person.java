package ooad.day02.exercise3;

public class Person {
	private IHead head;
	private IBody body;
	private ILeg leg;

	public Person() {
	}

	public IHead getHead() {
		return head;
	}

	public void setHead(IHead head) {
		this.head = head;
	}

	public IBody getBody() {
		return body;
	}

	public void setBody(IBody body) {
		this.body = body;
	}

	public ILeg getLeg() {
		return leg;
	}

	public void setLeg(ILeg leg) {
		this.leg = leg;
	}

}
