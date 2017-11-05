package xml.day03.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 使用SAX解析xnl文件
 * @author cheney
 *
 */
public class SaxParse {
	private List<Student> stus;
	private Student stu;
	public List<Student> read(String filePath) {
		stus=new ArrayList<Student>();
		try {
			//1.获取SAXParseFactory对象
			SAXParserFactory factory=SAXParserFactory.newInstance();
			//2.获取SAXParser解析器对象
			SAXParser parser = factory.newSAXParser();
			//3.利用parser解析xml文件
			parser.parse(filePath, new DefaultHandler(){
				String currentQname;
				@Override
				public void startDocument() throws SAXException {
					System.out.println("文档开始解析");
				}

				@Override
				public void endDocument() throws SAXException {
					System.out.println("文档结束解析");
				}

				/**
				 * 
				 * @param uri:命名空间
				 * @param localName:不带前缀名
				 * @param qName:带前缀名
				 * @param attributes:属性对象
				 * @throws SAXException
				 */
				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					this.currentQname=qName;
//					System.out.println("元素开始解析");
					if(qName.equals("stu")){
						stu=new Student();
						String id = attributes.getValue("id");
						stu.setId(Long.valueOf(id));
					}
				}

				@Override
				public void endElement(String uri, String localName,
						String qName) throws SAXException {
//					System.out.println("元素结束解析");
					if(qName.equals("stu")){
						stus.add(stu);
					}
					this.currentQname=null;
				}

				@Override
				public void characters(char[] ch, int start, int length)
						throws SAXException {
//					System.out.println("获取元素内容");
					String text=new String(ch,start,length);
					if("name".equals(this.currentQname)){
						stu.setName(text);
					}else if("age".equals(this.currentQname)){
						stu.setAge(Integer.parseInt(text));
					}
				}
				
			});
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return stus;
	}
	
	public static void main(String[] args) {
		List<Student> stus = new SaxParse().read("src/xml/day03/student.xml");
		System.out.println(stus);
	}
}
