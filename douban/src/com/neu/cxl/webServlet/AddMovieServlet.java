package com.neu.cxl.webServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.Resource;
import com.neu.cxl.ServiceImpl.AdminServiceImpl;
import com.neu.cxl.Utils.Utils;

/**
 * Servlet implementation class AddMovieServlet
 */
@WebServlet("/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String movieid=Utils.getUUID();
		request.getSession().setAttribute("movieid", movieid);
		String moviename=request.getParameter("moviename");
		String movietype=request.getParameter("movietype");
		String movieimgurl=request.getParameter("movieimgurl");
		String avgscore=request.getParameter("avgscore");
		String movielanguage=request.getParameter("movienlanguage");
		String moviearea=request.getParameter("moviearea");
		String movieyear=request.getParameter("movieyear");
		String movietime=request.getParameter("movietime");
		String movieurl=request.getParameter("movieurl");
		String moviedescription=request.getParameter("moviedescription");

		Resource r=new Resource();
		r.setAvgScore(avgscore);
		r.setMovieArea(moviearea);
		r.setMovieDescription(moviedescription);
		r.setMovieId(movieid);
		r.setMovieImgUrl(movieimgurl);
		r.setMovieLanguage(movielanguage);
		r.setMovieName(moviename);
		r.setMovieTime(movietime);
		r.setMovieType(movietype);
		r.setMovieUrl(movieurl);
		r.setMovieYear(movieyear);
		AdminServiceImpl adminServiceImpl=new AdminServiceImpl();
		try {
			if(adminServiceImpl.addMovie(r))
			{
				request.setAttribute("addmsg", "添加成功");
				response.getWriter().write("<script languge='javascript'>alert('添加成功'); window.location.href='JSP/actorAdd.jsp';</script>");
				
			}
			else
			{
				request.setAttribute("addmsg", "添加失败");
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
