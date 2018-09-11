package com.neu.cxl.webServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.Actor;
import com.neu.cxl.Entity.ActorToMovie;
import com.neu.cxl.Entity.Director;
import com.neu.cxl.Entity.DirectorToMovie;
import com.neu.cxl.ServiceImpl.AdminServiceImpl;
import com.neu.cxl.Utils.Utils;

/**
 * Servlet implementation class AddDirectorServlet
 */
@WebServlet("/AddDirectorServlet")
public class AddDirectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDirectorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String directorid=Utils.getUUID();
		String movieid=request.getParameter("movieid");
		request.getSession().setAttribute("directorid", directorid);
		Director director=new Director();
		director.setDirectorId(directorid);
		director.setDirectorName(request.getParameter("directorname"));
		director.setDirectorSex(request.getParameter("directorsex"));
		director.setDirectorSign(request.getParameter("directorsign"));
		director.setDirectorBirthday(request.getParameter("directorbirthday"));
		director.setDirectorBorned(request.getParameter("directorborned"));
		director.setDirectorWork(request.getParameter("directorwork"));
		director.setDirectorIntroduction(request.getParameter("directorintroduction"));
		director.setDirectorPhoto(request.getParameter("directorphoto"));
		
		AdminServiceImpl adminServiceImpl=new AdminServiceImpl();
		try {
			if(adminServiceImpl.addDirector(director))
			{
				if((String) request.getSession().getAttribute("movieid")==null)
				{
					DirectorToMovie directortomovie=new DirectorToMovie();
					directortomovie.setDirectorId(directorid);
					directortomovie.setResourceId(movieid);
					adminServiceImpl.addCorrespondence(directortomovie);
			}else
			{
				DirectorToMovie directortomovie=new DirectorToMovie();
				directortomovie.setDirectorId(directorid);
				directortomovie.setResourceId((String) request.getSession().getAttribute("movieid"));
				adminServiceImpl.addCorrespondence(directortomovie);
			}
				
				request.setAttribute("adddirectormsg", "添加成功");
				response.getWriter().write("<script languge='javascript'>alert('添加成功'); if(window.confirm('是否继续添加导演?')){window.location.href='JSP/directorAdd.jsp';}else {window.location.href='JSP/movieSelect.jsp';}</script>");
				
			}
			else
			{
				request.setAttribute("adddirectormsg", "添加失败");
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
