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
import com.neu.cxl.Entity.ResultSort;

import com.neu.cxl.ServiceImpl.ResourceServiceImpl;

/**
 * Servlet implementation class SelectMovieServletByUser
 */
@WebServlet("/SelectMovieServletByUser")
public class SelectMovieServletByUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMovieServletByUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword=request.getParameter("keyword");
		String type=(String)request.getParameter("type");
		ResourceServiceImpl resourceServiceImpl=new ResourceServiceImpl();
		ArrayList<Resource> movieList=new ArrayList<Resource>();
		
		//System.out.println(type);
		try {
			if(type.equals("moviename"))
			{
				
				movieList=resourceServiceImpl.selectMovieByNameKeyword(keyword);
			}
			else if(type.equals("avgscore"))
			{
				movieList=resourceServiceImpl.selectMovieByScore(keyword);
			}
			else if(type.equals("movietype"))
			{
				movieList=resourceServiceImpl.selectMovieByType(keyword);
			}
			else if(type.equals("movieactorid"))
			{
				movieList=resourceServiceImpl.selectMovieByActor(keyword);
			}
			else if(type.equals("movieyear"))
			{
				movieList=resourceServiceImpl.selectMovieByYear(keyword);
			}
			
			//System.out.println(movieList.size());
			request.setAttribute("movielist", movieList);
			request.getRequestDispatcher("moviesearch.jsp").forward(request, response);
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
