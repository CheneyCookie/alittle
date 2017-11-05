package ooad.day03.exercise5;

public class FileSystem {
	File rootFolder=null;

	public FileSystem(String name) {
		rootFolder=new File(name);
	}

	@Override
	public String toString() {
		return "FileSystem [rootFolder=" + rootFolder + "]";
	}
	
	
}
