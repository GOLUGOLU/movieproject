package com.neu.cxl.webServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.Director;
import com.neu.cxl.ServiceImpl.AdminServiceImpl;

/**
 * Servlet implementation class UpdateDirectorServlet
 */
@WebServlet("/UpdateDirectorServlet")
public class UpdateDirectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDirectorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String directorid=request.getParameter("directorid");
		String directorname=request.getParameter("directorname");
		String directorsex=request.getParameter("directorsex");
		String directorsign=request.getParameter("directorsign");
		String directorbirthday=request.getParameter("directorbirthday");
		String directorwork=request.getParameter("directorwork");
		String directorborned=request.getParameter("directorborned");
		String directorphoto=request.getParameter("directorphoto");
		String directorintroduction=request.getParameter("directorintroduction");

		Director r=new Director();
		r.setDirectorId(directorid);
		r.setDirectorName(directorname);
		r.setDirectorSex(directorsex);
		r.setDirectorSign(directorsign);
		r.setDirectorBirthday(directorbirthday);
		r.setDirectorWork(directorwork);
		r.setDirectorBorned(directorborned);
		r.setDirectorPhoto(directorphoto);
		r.setDirectorIntroduction(directorintroduction);
		
		AdminServiceImpl adminServiceImpl=new AdminServiceImpl();
		try {
			//System.out.println(directorid);
			if(adminServiceImpl.updateDirector(r))
			{
			//response.getWriter().write("<script type='text/javascript'>alert('修改成功')</script>");
			response.getWriter().write("<script languge='javascript'>alert('修改成功'); window.location.href='JSP/directorSelect.jsp';</script>");

			request.setAttribute("updatemsg", "修改成功");
			//response.sendRedirect("JSP/directorUpdate.jsp");
		    //request.getRequestDispatcher("JSP/directorSelect.jsp").forward(request, response);
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
