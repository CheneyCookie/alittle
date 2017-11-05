package ooad.day03.exercise7;

/**
 * 九宫格
 * 
 * @author cheney
 *
 */
public class Sudoku {
	private Person[][] sudoku;
	private Person person;

	public Sudoku(Person person) {
		sudoku = new Person[3][3];
		this.person = person;
		sudoku[1][1] = this.person;
	}

	public void move() {
		try {
			if (person.getStatus().equals("live")) {
				if (person.getDirect().equals("west")) {
					for (int i = 0; i < sudoku.length; i++) {
						for (int j = 0; j < sudoku[i].length; j++) {
							if (sudoku[i][j] != null) {
								sudoku[i][j - 1] = sudoku[i][j];
								sudoku[i][j] = null;
								return;
							}
						}
					}
				} else if (person.getDirect().equals("east")) {
					for (int i = 0; i < sudoku.length; i++) {
						for (int j = 0; j < sudoku[i].length; j++) {
							if (sudoku[i][j] != null) {
								sudoku[i][j + 1] = sudoku[i][j];
								sudoku[i][j] = null;
								return;
							}
						}
					}
				} else if (person.getDirect().equals("north")) {
					for (int i = 0; i < sudoku.length; i++) {
						for (int j = 0; j < sudoku[i].length; j++) {
							if (sudoku[i][j] != null) {
								sudoku[i - 1][j] = sudoku[i][j];
								sudoku[i][j] = null;
								return;
							}
						}
					}
				} else if (person.getDirect().equals("south")) {
					for (int i = 0; i < sudoku.length; i++) {
						for (int j = 0; j < sudoku[i].length; j++) {
							if (sudoku[i][j] != null) {
								sudoku[i + 1][j] = sudoku[i][j];
								sudoku[i][j] = null;
								return;
							}
						}
					}
				}else{
					System.out.println("方向错误");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			person.setStatus("dead");
		}
	}

	public void getLocation() {
		if (person.getStatus().equals("live")) {
			for (int i = 0; i < sudoku.length; i++) {
				for (int j = 0; j < sudoku[i].length; j++) {
					if (sudoku[i][j] != null) {
						System.out.println(i + "," + j);
					}
				}
			}
		}
	}
}
