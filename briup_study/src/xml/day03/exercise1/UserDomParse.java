package xml.day03.exercise1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class UserDomParse {

	public List<User> parseXML(String fileName) {
		List<User> users = new ArrayList<User>();
		;
		User user = null;
		try {
			// 获得一个负责生产DocumentBuilder对象的工厂实例
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();

			// 设置是否支持命名空间
			factory.setNamespaceAware(true);

			// 通过工厂获得一个DocumentBuilder对象，DocumentBuilder可以获得Document对象
			DocumentBuilder builder = factory.newDocumentBuilder();

			// 如果是xml上面声明了对DTD的引用，则可以这样忽略DTD，否则会自动根据地址查找DTD
			builder.setEntityResolver(new EntityResolver() {

				@Override
				public InputSource resolveEntity(String publicId,
						String systemId) throws SAXException, IOException {
					byte[] data = "<?xml version=\"1.1\" encoding=\"UTF-8\"?>"
							.getBytes();
					return new InputSource(new ByteArrayInputStream(data));
				}
			});

			// 获得Document对象，这个对象可以表示一个文档，如xml文档
			Document document = builder.parse(fileName);

			// 获得根元素
			Element root = document.getDocumentElement();
			// 获得根元素的所有子节点
			NodeList rootChildNodes = root.getChildNodes();

			for (int i = 0; i < rootChildNodes.getLength(); i++) {
				Node node = rootChildNodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {

					user = new User();
					String name = node.getAttributes().getNamedItem("name")
							.getNodeValue();
					Double cost = Double.parseDouble(node.getTextContent());
					user.setName(name);
					user.setCost(cost);
					users.add(user);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return users;
	}

	public void update(String filePath,User user) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document=builder.parse(filePath);
			
			NodeList elementByTagName=document.getElementsByTagName("user");
			for (int i = 0; i < elementByTagName.getLength(); i++) {
				Node node=elementByTagName.item(i);
				String name = node.getAttributes().getNamedItem("name").getNodeValue();
				if(name.equals(user.getName())){
					node.setTextContent(user.getCost().toString());
					break;
				}
			}
			
			TransformerFactory tff=TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.transform(new DOMSource(document), new StreamResult(filePath));
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

	}
	
	public void remove(String filePath,String username){
		try {
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(filePath);
			
			NodeList elementByTagName=document.getElementsByTagName("user");
			for (int i = 0; i < elementByTagName.getLength(); i++) {
				Node node = elementByTagName.item(i);
				String name=node.getAttributes().getNamedItem("name").getNodeValue();
				if(name.equals(username)){
					node.getParentNode().removeChild(node);
					break;
				}
			}
			
			TransformerFactory tff=TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.transform(new DOMSource(document), new StreamResult(filePath));
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	
	public void add(String filePath,User user){
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(filePath);
			
			Element userElement=document.createElement("user");
			userElement.setAttribute("name", user.getName());
			userElement.setTextContent(user.getCost().toString());
			document.getDocumentElement().appendChild(userElement);
			
			TransformerFactory tff = TransformerFactory.newInstance();
			Transformer tf = tff.newTransformer();
			tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.transform(new DOMSource(document), new StreamResult(filePath));
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UserDomParse parse=new UserDomParse();
		String filePath="conf/user.xml";
		List<User> users = parse.parseXML(filePath);
		System.out.println(users);
		parse.update(filePath, new User("tom",17.0));
		parse.remove(filePath, "jack");
		parse.add(filePath, new User("cheney",100.0));
		
	}
}
