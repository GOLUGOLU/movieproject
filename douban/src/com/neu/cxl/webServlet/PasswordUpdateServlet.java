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
 * Servlet implementation class PasswordUpdateServlet
 */
@WebServlet("/PasswordUpdateServlet")
public class PasswordUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("newpassword");
		User user=new User();
		user.setUserName(username);
		user.setPassword(password);

		
		UserServiceImpl userservice=new UserServiceImpl();
		try {
			if(userservice.updatePassword(user))
			{
				response.getWriter().write("<script languge='javascript'>alert('密码重置成功'); window.location.href='login.html';</script>");
			}
			else
			{
				response.getWriter().write("<script languge='javascript'>alert('密码重置失败'); window.location.href='passswordchange.html';</script>");
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
