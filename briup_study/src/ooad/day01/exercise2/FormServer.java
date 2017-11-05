package ooad.day01.exercise2;

import java.util.ArrayList;
import java.util.List;

public class FormServer {
	public static void main(String[] args) {
		Farm farm = new Farm();
		List<Cow> cows = farm.getCows();
		int year=farm.getYear();
		int number=1;
		
		
		while(year<10){
			List<Cow> newCows=new ArrayList<Cow>();
			year=farm.timesGo();
			for(Cow cow:cows){
				cow.growUp();
				Cow newCow=cow.birthCow();
				if(newCow!=null){
					newCows.add(newCow);
				}
			}
			cows.addAll(newCows);
		}
		
		number=farm.getNumber();
		System.out.println(number);
		
	}
}
