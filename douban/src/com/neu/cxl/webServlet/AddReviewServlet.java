package com.neu.cxl.webServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.Review;
import com.neu.cxl.ServiceImpl.ReviewServiceImpl;
import com.neu.cxl.Utils.Utils;

/**
 * Servlet implementation class AddReviewServlet
 */
@WebServlet("/AddReviewServlet")
public class AddReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReviewServlet() {
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		String reviewid=Utils.getUUID();
		String reviewuser=request.getParameter("reviewuser");
		String reviewcontent=request.getParameter("reviewcontent");
		String reviewmovieid=request.getParameter("movieid");
		String reviewmoviename=request.getParameter("moviename");
		String reviewscore=request.getParameter("reviewscore");
		//System.out.println(date);
		Review r=new Review();
		
		r.setReviewContent(reviewcontent);
		r.setReviewGoodCount("0");
		r.setReviewId(reviewid);
		r.setReviewMovieId(reviewmovieid);
		r.setReviewMovieName(reviewmoviename);
		r.setReviewTime(date);
		r.setReviewUser(reviewuser);
		r.setReviewScore(reviewscore);
		
		ReviewServiceImpl reviewServiceImpl=new ReviewServiceImpl();
		try {
			if(reviewServiceImpl.publishReview(r))
			{
				response.getWriter().write("<script languge='javascript'>alert('评论发表成功');</script>");
			}
			else
			{
				response.getWriter().write("<script languge='javascript'>alert('评论发表失败'); ;</script>");
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
