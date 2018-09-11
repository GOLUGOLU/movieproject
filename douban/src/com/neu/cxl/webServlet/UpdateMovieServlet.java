package com.neu.cxl.webServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.Resource;
import com.neu.cxl.ServiceImpl.AdminServiceImpl;

/**
 * Servlet implementation class UpdateMovieServlet
 */
@WebServlet("/UpdateMovieServlet")
public class UpdateMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String movieid=request.getParameter("movieid");
		String moviename=request.getParameter("moviename");
		String movietype=request.getParameter("movietype");
		String movieimgurl=request.getParameter("movieimgurl");
		String movieavgscore=request.getParameter("movieavgscore");
		String movielanguage=request.getParameter("movielanguage");
		String moviearea=request.getParameter("moviearea");
		String movieyear=request.getParameter("movieyear");
		String movietime=request.getParameter("movietime");
		String movieurl=request.getParameter("movieurl");
		String moviereviewnumber=request.getParameter("moviereviewnumber");
		String moviedescription=request.getParameter("moviedescription");
		Resource r=new Resource();
		r.setMovieId(movieid);
		r.setAvgScore(movieavgscore);
		r.setMovieName(moviename);
		r.setMovieType(movietype);
		r.setMovieImgUrl(movieimgurl);
		r.setMovieLanguage(movielanguage);
		r.setMovieArea(moviearea);
		r.setMovieTime(movietime);
		r.setMovieDescription(moviedescription);
		r.setMovieUrl(movieurl);
		r.setMovieReviewNumber(moviereviewnumber);
		r.setMovieYear(movieyear);
		
		AdminServiceImpl adminServiceImpl=new AdminServiceImpl();
		try {
			//System.out.println(movieid);
			if(adminServiceImpl.updateMovie(r))
			{
			//response.getWriter().write("<script type='text/javascript'>alert('修改成功')</script>");
			response.getWriter().write("<script languge='javascript'>alert('修改成功'); window.location.href='JSP/movieSelect.jsp';</script>");

			request.setAttribute("updatemsg", "修改成功");
			//response.sendRedirect("JSP/movieUpdate.jsp");
		    //request.getRequestDispatcher("JSP/movieSelect.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("updatemsg", "修改失败");
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
