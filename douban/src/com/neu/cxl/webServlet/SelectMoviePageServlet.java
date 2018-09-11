package com.neu.cxl.webServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.Actor;
import com.neu.cxl.Entity.Director;
import com.neu.cxl.Entity.Resource;
import com.neu.cxl.Entity.Review;
import com.neu.cxl.ServiceImpl.ResourceServiceImpl;
import com.neu.cxl.ServiceImpl.ReviewServiceImpl;

/**
 * Servlet implementation class SelectMoviePageServlet
 */
@WebServlet("/SelectMoviePageServlet")
public class SelectMoviePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMoviePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieid=request.getParameter("movieid");
		ResourceServiceImpl resourceServiceImpl=new ResourceServiceImpl();
		ReviewServiceImpl reviewServiceImpl=new ReviewServiceImpl();
		Resource movieList=new Resource();
		ArrayList<Actor> actorList=new ArrayList<Actor>();
		ArrayList<Director> directorList=new ArrayList<Director>();
		ArrayList<Review> reviewList=new ArrayList<Review>();
		
		try {
			movieList=resourceServiceImpl.selectMovieById(movieid);
			actorList=resourceServiceImpl.selectActorByMovieId(movieid);
			directorList=resourceServiceImpl.selectDirectorByMovieId(movieid);
			reviewList=reviewServiceImpl.selectReview(movieid);
			//System.out.println(movieList.getAvgScore());
			request.setAttribute("movie", movieList);
			request.setAttribute("actor", actorList);
			request.setAttribute("director", directorList);
			request.setAttribute("review", reviewList);
			request.getRequestDispatcher("moviepage.jsp").forward(request, response);
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
