package com.spring.struts2.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import com.spring.struts2.bean.Person;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.从applicaton域中的到IOC容器的
		ServletContext servletContext=getServletContext();
		ApplicationContext ctx=(ApplicationContext) servletContext.getAttribute("applicationContext");
		
		//2.从IOC容器中得到需要的bean
		Person person=ctx.getBean(Person.class);
		person.hello();
	}

}
