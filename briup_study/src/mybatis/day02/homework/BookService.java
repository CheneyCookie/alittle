package mybatis.day02.homework;

import java.util.List;
import java.util.Map;

import mybatis.day01.homework.work1.util.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;

/**
 * 在BookMapper.java接口中定义方法
 * 在BookService中调用BookMapper.java接口中方法
 * 完成以下功能(注意参照笔记中的实例)
 */
//处理书籍相关信息的服务类
public class BookService {
	SqlSession session=MySqlSessionFactory.openSession();
	BookMapper bookMapper=session.getMapper(BookMapper.class);
	//添加书籍
	//书籍的名称不能重复
	public void addBook(Book book){
		bookMapper.addBook(book);
		session.commit();
	}
	
	//删除书籍
	//id值不存在则不能删除
	public void removeBook(Integer id){
		bookMapper.removeBook(id);
		session.commit();
	}
	
	//查找书籍
	//通过名字
	public Book findBookByName(String bookName){
		Book book = bookMapper.findBookByName(bookName);
		return book;
	}
	
	//查找书籍
	//通过id
	public Book findBookById(Integer id){
		Book book = bookMapper.findBookById(id);
		return book;
	}
	
	//查找所有书籍
	public List<Book> findAllBooks(){
		List<Book> books=bookMapper.findAllBooks();
		return books;
	}
	
	//查找所有书籍的名字
	public List<String> findAllBooksName(){
		List<String> names=bookMapper.findAllBooksName();
		return names;
	}
	
	//查找一共有多少本书籍
	public int findCountOfBook(){
		int i=bookMapper.findCountOfBook();
		return i;
	}
	
	//修改书籍
	//通过id确定修改的是那本书
	public void updateBook(Book book){
		bookMapper.updateBook(book);
		session.commit();
	}
	
	//查询所有书籍的名字和对应的作者
	public List<Map<String,Object>> findBookNameAndAuthor(){
		List<Map<String,Object>> nameAndAuthor=bookMapper.findBookNameAndAuthor();
		return nameAndAuthor;
	}
	
}
