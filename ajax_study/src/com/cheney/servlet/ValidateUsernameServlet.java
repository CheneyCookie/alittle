package com.cheney.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validateUsername")
public class ValidateUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ValidateUsernameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> userNames=Arrays.asList("AAA","BBB","CCC");
		
		String userName=request.getParameter("userName");
		String result=null;
		if(userNames.contains(userName)){
			result="<font color='red'>该用户名已被占用</font>";
		}else{
			result="<font color='green'>该用户名可用</font>";
		}
		
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
