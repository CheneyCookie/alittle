package ooad.day03.exercise6;

public class Test {
	public static void main(String[] args) {
		Subject children=new Children();
		Observer father=new Father();
		Observer mather=new Mather();
		children.add(father);
		children.add(mather);
		children.operation();
	}
}
