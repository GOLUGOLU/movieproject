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
 * Servlet implementation class SelectMovieByType
 */
@WebServlet("/SelectMovieByType")
public class SelectMovieByType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMovieByType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=(String)request.getParameter("type");
		ResourceServiceImpl resourceServiceImpl=new ResourceServiceImpl();
		ArrayList<Resource> movieList=new ArrayList();
		
		//System.out.println(type);
		try {
			if(type.equals("战争"))
			{
				
				movieList=resourceServiceImpl.selectMovieByType(type);
			}
			else if(type.equals("动作"))
			{
				movieList=resourceServiceImpl.selectMovieByType(type);
			}
			else if(type.equals("喜剧"))
			{
				movieList=resourceServiceImpl.selectMovieByType(type);
			}
			else if(type.equals("惊悚"))
			{
				movieList=resourceServiceImpl.selectMovieByType(type);
			}
			else if(type.equals("悬疑"))
			{
				movieList=resourceServiceImpl.selectMovieByType(type);
			}
			else if(type.equals("历史"))
			{
				movieList=resourceServiceImpl.selectMovieByType(type);
			}
			else if(type.equals("灾难"))
			{
				movieList=resourceServiceImpl.selectMovieByType(type);
			}
			else if(type.equals("犯罪"))
			{
				movieList=resourceServiceImpl.selectMovieByType(type);
			}
			else if(type.equals("科幻"))
			{
				movieList=resourceServiceImpl.selectMovieByType(type);
			}
			else if(type.equals("爱情"))
			{
				movieList=resourceServiceImpl.selectMovieByType(type);
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
