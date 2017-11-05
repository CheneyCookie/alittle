package ooad.day01.exercise2;

import java.util.ArrayList;
import java.util.List;

public class Farm {
	private List<Cow> cows;
	private int year;
	private int number;

	public Farm() {
		cows=new ArrayList<Cow>();
		cows.add(new Cow(3));
		year=0;
	}

	public List<Cow> getCows() {
		return cows;
	}

	public void setCows(List<Cow> cows) {
		this.cows = cows;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getNumber() {
		number=cows.size();
		return number;
	}

	public int timesGo(){
		year++;
		return year;
	}
}
