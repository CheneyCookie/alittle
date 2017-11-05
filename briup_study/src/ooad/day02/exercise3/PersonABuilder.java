package ooad.day02.exercise3;

public class PersonABuilder implements PersonBuilder{

	private Person personA;
	
	
	
	public PersonABuilder() {
		personA=new Person();
	}

	@Override
	public void buildHead() {
		personA.setHead(new HeadImpl());
	}

	@Override
	public void buildBody() {
		personA.setBody(new BodyImpl());
	}

	@Override
	public void buildLeg() {
		personA.setLeg(new LegImpl());
	}

	@Override
	public Person getPerson() {
		return personA;
	}

}
