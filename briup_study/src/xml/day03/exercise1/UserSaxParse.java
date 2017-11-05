package xml.day03.exercise1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserSaxParse {
	private List<User> users;
	private User user;

	public List<User> read(String filePath) {
		users = new ArrayList<User>();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			parser.parse(filePath, new DefaultHandler() {
				String currentName;

				@Override
				public void startDocument() throws SAXException {
				}

				@Override
				public void endDocument() throws SAXException {
				}

				@Override
				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {
					
					this.currentName = qName;
					if (qName.equals("user")) {
						user = new User();
						String name = attributes.getValue("name");
						user.setName(name);
					}
				}

				@Override
				public void endElement(String uri, String localName,
						String qName) throws SAXException {
					if (qName.equals("user")) {
						users.add(user);
					}
					this.currentName = null;
				}

				@Override
				public void characters(char[] ch, int start, int length)
						throws SAXException {
					String text = new String(ch, start, length);
					if ("user".equals(currentName)) {
						Double cost = Double.parseDouble(text);
						user.setCost(cost);
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
		return users;
	}
	
	public static void main(String[] args) {
		List<User> users=new UserSaxParse().read("conf/user.xml");
		System.out.println(users);
	}
}
