package ooad.day03.exercise7;

public class Test {
	public static void main(String[] args) {
		Person person=new Person();
		Sudoku sudoku=new Sudoku(person);
		
		person.turn("right");
		sudoku.move();
		sudoku.getLocation();
		System.out.println(person.getStatus());
		person.turn("right");
		sudoku.move();
		sudoku.getLocation();
		System.out.println(person.getStatus());
//		person.turn("right");
		sudoku.move();
		sudoku.getLocation();
		System.out.println(person.getStatus());
//		person.turn("right");
		sudoku.move();
		sudoku.getLocation();
		System.out.println(person.getStatus());
	}
}
