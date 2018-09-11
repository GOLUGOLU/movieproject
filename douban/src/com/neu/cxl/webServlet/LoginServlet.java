package com.neu.cxl.webServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.Review;
import com.neu.cxl.Entity.User;
import com.neu.cxl.ServiceImpl.ReviewServiceImpl;
import com.neu.cxl.ServiceImpl.UserServiceImpl;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public LoginServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//System.out.println(username+password);
		User user=new User();
		user.setUserName(username);
		user.setPassword(password);

		ArrayList <Review>reviewList=new ArrayList<Review>();
		UserServiceImpl userservice=new UserServiceImpl();
		ReviewServiceImpl reviewServiceImpl=new ReviewServiceImpl();
		
		
		try {
		 if(!("".equals(userservice.login(user).getUserName())||userservice.login(user).getUserName()==null))
			{
			 	reviewList=reviewServiceImpl.selectReview(user);
			 	request.getSession().setAttribute("review", reviewList);
				request.getSession().setAttribute("user", userservice.login(user));
				request.getSession().setAttribute("username",userservice.login(user).getUserName() );
			    response.getWriter().println( "登录成功");
			    //out.println(userservice.login(user).getUserName());
			   // out.close();
			   //System.out.println(userservice.login(user).getRole());
			
				if("管理员".equals((String)userservice.login(user).getRole()))
				{
				request.getRequestDispatcher("/JSP/manager.jsp").forward(request, response);
				
				}
				else {
					
					request.getRequestDispatcher("/in_index.jsp").forward(request, response);
					
				}
				 
				
			}
		 else
			{
			 out.println( "用户名或密码错误");
			// response.sendRedirect("login.html");
			 out.close(); 
			 return;
			 
					
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
