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

import com.neu.cxl.Entity.User;
import com.neu.cxl.ServiceImpl.ResourceServiceImpl;
import com.neu.cxl.ServiceImpl.UserServiceImpl;
@WebServlet("/SelectMovieByNameServlet")
public class SelectMovieByNameServlet extends HttpServlet {

	
	public SelectMovieByNameServlet() {
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

	
	response.setContentType("text/html;charset=utf-8");
	
	String moviename=request.getParameter("selectmoviename");
	ResourceServiceImpl resourceServiceImpl=new ResourceServiceImpl();
	try {
		ArrayList movieList=resourceServiceImpl.selectMovieByNameKeyword(moviename);
		//System.out.println(movieList.size());
		request.setAttribute("movielist", movieList);
		request.getRequestDispatcher("JSP/movieSelect.jsp").forward(request, response);
	} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


		
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}
		
	public void init() throws ServletException {
		// Put your code here
	}

}
