package com.neu.cxl.webServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.User;
import com.neu.cxl.ServiceImpl.UserServiceImpl;

/**
 * Servlet implementation class CheckUserServlet
 */
@WebServlet("/check")
public class CheckUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		User u=new User();
		//System.out.println(request.getParameter("username"));
		u.setUserName(request.getParameter("username"));
		UserServiceImpl userservice=new UserServiceImpl();
		try {
			if("".equals(userservice.checkUser(u).getUserName())||userservice.checkUser(u).getUserName()==null)
			{
				
				 response.getWriter().println("用户名可以使用!");
			}
			  else
			       {
				  response.getWriter().println("用户名已经被占用!");
			       }
			   
			      
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
