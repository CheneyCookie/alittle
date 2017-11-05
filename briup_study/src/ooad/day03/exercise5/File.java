package ooad.day03.exercise5;

import java.util.Vector;

public class File {
	private String name;
	private File parent;
	private Vector<File> files = new Vector<File>();

	public File(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getParent() {
		return parent;
	}

	public void setParent(File parent) {
		this.parent = parent;
	}

	public void addFile(File file){
		file.setParent(this);
		files.add(file);
	}
	
	public void deleteFile(File file){
		files.remove(file);
	}

	public Vector<File> getFiles() {
		return files;
	}

	@Override
	public String toString() {
		return "File [name=" + name + ", files=" + files
				+ "]";
	}
	
}
