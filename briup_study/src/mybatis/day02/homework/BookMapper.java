package mybatis.day02.homework;

import java.util.List;
import java.util.Map;

public interface BookMapper {
	
	void addBook(Book book);

	void removeBook(Integer id);

	Book findBookByName(String bookName);

	Book findBookById(Integer id);

	List<Book> findAllBooks();

	List<String> findAllBooksName();

	int findCountOfBook();

	void updateBook(Book book);

	List<Map<String,Object>> findBookNameAndAuthor();
}
