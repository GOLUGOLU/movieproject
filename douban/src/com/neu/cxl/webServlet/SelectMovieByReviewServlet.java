package com.neu.cxl.webServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.Resource;
import com.neu.cxl.ServiceImpl.ResourceServiceImpl;

/**
 * Servlet implementation class SelectMovieByReviewServlet
 */
@WebServlet("/SelectMovieByReviewServlet")
public class SelectMovieByReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMovieByReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		
		ResourceServiceImpl resourceServiceImpl=new ResourceServiceImpl();
		try {
			ArrayList <Resource>movieList=resourceServiceImpl.selectMovieSortByReviewNum();
			//System.out.println(movieList.size());
			request.setAttribute("movielist", movieList);
			request.getRequestDispatcher("in_index.jsp").forward(request, response);
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
