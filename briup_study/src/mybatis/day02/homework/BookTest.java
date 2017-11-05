package mybatis.day02.homework;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class BookTest {
	private BookService bookService=new BookService();
	
	@Test
	public void testAddBook(){
		Book book=new Book(2,"BB","CC",new Date(),1000.00);
		bookService.addBook(book);
	}
	
	@Test
	public void testRemoveBook(){
		bookService.removeBook(1);
	}
	
	@Test
	public void testFindBookByName(){
		Book book = bookService.findBookByName("AA");
		System.out.println(book);
	}
	
	@Test
	public void testFindBookById(){
		Book book = bookService.findBookById(1);
		System.out.println(book);
	}
	
	@Test
	public void testFindAllBook(){
		List<Book> books = bookService.findAllBooks();
		System.out.println(books);
	}
	
	@Test
	public void testFindAllBooksName(){
		List<String> names = bookService.findAllBooksName();
		System.out.println(names);
	}
	
	@Test
	public void testFindCountOfBook(){
		int i = bookService.findCountOfBook();
		System.out.println(i);
	}
	
	@Test
	public void testUpdateBook(){
		Book book=new Book(1,"DD","DD",new Date(),500.00);
		bookService.updateBook(book);
	}
	
	@Test
	public void testFindBookNameAndAuthor(){
		List<Map<String,Object>> bookNameAndAuthor = bookService.findBookNameAndAuthor();
		for (Map<String, Object> map : bookNameAndAuthor) {
			for(String key:map.keySet()){
				System.out.println(key+":"+map.get(key));
			}
		}
	}
}
