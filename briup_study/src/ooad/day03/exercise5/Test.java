package ooad.day03.exercise5;

public class Test {
	public static void main(String[] args) {
		FileSystem fileSystem=new FileSystem("根目录");
		File folder=new File("文件夹");
		File file=new File("a文件");
		
		folder.addFile(file);
		fileSystem.rootFolder.addFile(folder);
		System.out.println(fileSystem);
	}
}
