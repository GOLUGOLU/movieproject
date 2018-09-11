package com.neu.cxl.webServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.ServiceImpl.AdminServiceImpl;

/**
 * Servlet implementation class SelectDirectorByNameServlet
 */
@WebServlet("/SelectDirectorByNameServlet")
public class SelectDirectorByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectDirectorByNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=utf-8");
		
		String directorname=request.getParameter("selectdirectorname");
		AdminServiceImpl adminServiceImpl=new AdminServiceImpl();
		try {
			ArrayList directorList=adminServiceImpl.selectDirectorByNameKeyword(directorname);
			//System.out.println(movieList.size());
			request.setAttribute("directorlist", directorList);
			request.getRequestDispatcher("JSP/directorSelect.jsp").forward(request, response);
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
