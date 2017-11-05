package xml.day03.exercise3;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class StudentDom4jParse {
	private List<Student> students;
	
	public List<Student> readXML(String filePath){
		students=new ArrayList<Student>();
		Student student=null;
		
		try {
			SAXReader reader=new SAXReader();
			File file=new File(filePath);
			Document document=reader.read(file);
			Element rootElement = document.getRootElement();
			List<Element> elements = rootElement.elements();
			
			for (Element element : elements) {
				Integer id=Integer.parseInt(element.attribute("id").getValue());
				student=new Student();
				student.setId(id);
			
				List<Element> attElement=element.elements();
				for (Element element2 : attElement) {
					if(element2.getName().equals("name")){
						student.setName(element2.getText());
					}else if(element2.getName().equals("age")){
						student.setAge(Integer.parseInt(element2.getText()));
					}else if(element2.getName().equals("address")){
						Element element3=element2.element("city");
						student.setCity(element3.getText());
						students.add(student);
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
		return students;
	}
	
	public static void main(String[] args) {
		List<Student> students=new StudentDom4jParse().readXML("conf/student.xml");
		System.out.println(students);
	}
}
