package com.neu.cxl.webServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.cxl.Entity.User;
import com.neu.cxl.ServiceImpl.UserServiceImpl;
import com.neu.cxl.Utils.Utils;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	public RegisterServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		User user=new User();
		String userid=Utils.getUUID();
		String username=request.getParameter("username");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		String code=request.getParameter("verifycode");
		user.setUserId(userid);
		user.setUserName(username);
		user.setPassword(password);
		//user.setSex(request.getParameter("sex"));
		//user.setAge(request.getParameter("age"));
		user.setPhone(phone);
		//user.setEmail(request.getParameter("email"));
		
		if(!Pattern.matches("^1[3|5|8]\\d{9}$", phone))
		{
			out.print("手机号码格式有误");
			response.sendRedirect("register.html");
			return;
		}
		HttpSession session=request.getSession();
		
	    String sessioncode=(String) session.getAttribute("code");
		String number=(String) session.getAttribute("number");
		Long time=(Long) session.getAttribute("time");
		
		session.removeAttribute("code");
		session.removeAttribute("number");
		session.removeAttribute("time");
		
		/*if(!number.trim().equalsIgnoreCase(number))
		{
			
		}*/
		//System.out.println(sessioncode+"   "+code );
		if(sessioncode==null)
		{
			sessioncode="";
		}
		if(sessioncode.trim().equalsIgnoreCase(code))
		{
			response.addHeader("Content-Type", "text/html;charset=utf-8");
			UserServiceImpl userservice=new UserServiceImpl();
			try {
			
				if(userservice.register(user))
				{
					response.getWriter().write("<script languge='javascript'>alert('注册成功'); window.location.href='login.html';</script>");
					//request.getRequestDispatcher("login.html").forward(request, response);
				}
				else
				{
					response.getWriter().write("<script languge='javascript'>alert('注册失败'); window.location.href='register.html';</script>");
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
		else
		{
			response.getWriter().write("<script languge='javascript'>alert('验证码错误！'); window.location.href='register.html';</script>");
			//response.sendRedirect("register.html");
			return;
		}
		
		

		
		

	
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
