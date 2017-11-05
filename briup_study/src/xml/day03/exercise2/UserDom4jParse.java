package xml.day03.exercise2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class UserDom4jParse {
	List<User> users = null;
	
	public List<User> readXML(String filePath) {
		users = new ArrayList<User>();
		User user=null;

		try {
			SAXReader reader = new SAXReader();
			File file = new File(filePath);
			Document document = reader.read(file);
			Element rootElement=document.getRootElement();
			List<Element> elements=rootElement.elements();
			
			for (Element element : elements) {
				user=new User();
				String eleName=element.getName();
				String eleText=element.getText();
				if(eleName.equals("user")){
					user.setCost(Double.parseDouble(eleText));
				}
				List<Attribute> attributes=element.attributes();
				for (Attribute attribute : attributes) {
					String attName=attribute.getName();
					String attValue=attribute.getValue();
					if(attName.equals("name")){
						user.setName(attValue);
						users.add(user);
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public void createDom(String fileName){
		//获得文档对象
		Document document=DocumentHelper.createDocument();
		
		//添加根元素
		Element root=document.addElement("records");
		for (User user : users) {
			//根元素下添加子元素及其属性
			Element userElement=root.addElement("recode");
			Element nameElement=userElement.addElement("name");
			Element priceElement=userElement.addElement("price");
			nameElement.setText(user.getName());
			priceElement.setText(user.getCost().toString());
		}
		
		try {
			OutputFormat format=OutputFormat.createPrettyPrint();
			XMLWriter xw=new XMLWriter(new FileOutputStream(fileName),format);
			xw.write(document);
			xw.flush();
			xw.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UserDom4jParse parse=new UserDom4jParse();
		String filePath="conf/user.xml";
		String fileName="conf/record.xml";
		parse.readXML(filePath);
		parse.createDom(fileName);
	}
}
