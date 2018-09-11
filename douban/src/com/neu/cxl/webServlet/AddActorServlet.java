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
import com.neu.cxl.ServiceImpl.AdminServiceImpl;
import com.neu.cxl.Utils.Utils;

/**
 * Servlet implementation class AddActorServlet
 */
@WebServlet("/AddActorServlet")
public class AddActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddActorServlet() {
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
		String actorid=Utils.getUUID();
		request.getSession().setAttribute("actorid", actorid);
		Actor actor=new Actor();
		String movieid=request.getParameter("movieid");
		actor.setActorId(actorid);
		actor.setActorName(request.getParameter("actorname"));
		actor.setActorSex(request.getParameter("actorsex"));
		actor.setActorSign(request.getParameter("actorsign"));
		actor.setActorBirthday(request.getParameter("actorbirthday"));
		actor.setActorBorned(request.getParameter("actorborned"));
		actor.setActorWork(request.getParameter("actorwork"));
		actor.setActorIntroduction(request.getParameter("actorintroduction"));
		actor.setActorPhoto(request.getParameter("actorphoto"));
		
		AdminServiceImpl adminServiceImpl=new AdminServiceImpl();
		try {
			if(adminServiceImpl.addActor(actor))
			{
				
				if((String) request.getSession().getAttribute("movieid")==null)
				{
				ActorToMovie actortomovie=new ActorToMovie();
				actortomovie.setActorId(actorid);
				actortomovie.setResourceId(movieid);
				adminServiceImpl.addCorrespondence(actortomovie);
			}else
			{
				ActorToMovie actortomovie=new ActorToMovie();
				actortomovie.setActorId(actorid);
				actortomovie.setResourceId((String) request.getSession().getAttribute("movieid"));
				adminServiceImpl.addCorrespondence(actortomovie);
			}
				request.setAttribute("addactormsg", "添加成功");
				response.getWriter().write("<script languge='javascript'>alert('添加成功'); if(window.confirm('是否继续添加演员?')){window.location.href='JSP/actorAdd.jsp';}else {window.location.href='JSP/directorAdd.jsp';}</script>");
				
			}
			else
			{
				request.setAttribute("addactormsg", "添加失败");
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
