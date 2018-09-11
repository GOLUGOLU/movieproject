package com.neu.cxl.webServlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.Resource;
import com.neu.cxl.ServiceImpl.ResourceServiceImpl;

/**
 * Servlet implementation class SelectMovieServletByResultSort
 */
@WebServlet("/SelectMovieServletByResultSort")
public class SelectMovieServletByResultSort extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMovieServletByResultSort() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword=request.getParameter("keyword");
		String sort=(String)request.getParameter("sort");
		ResourceServiceImpl resourceServiceImpl=new ResourceServiceImpl();
		ArrayList<Resource> movieList=new ArrayList();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
