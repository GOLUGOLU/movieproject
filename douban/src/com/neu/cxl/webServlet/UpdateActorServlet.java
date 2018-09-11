package com.neu.cxl.webServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Entity.Actor;
import com.neu.cxl.Entity.Resource;
import com.neu.cxl.ServiceImpl.AdminServiceImpl;

/**
 * Servlet implementation class UpdateActorServlet
 */
@WebServlet("/UpdateActorServlet")
public class UpdateActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateActorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String actorid=request.getParameter("actorid");
		String actorname=request.getParameter("actorname");
		String actorsex=request.getParameter("actorsex");
		String actorsign=request.getParameter("actorsign");
		String actorbirthday=request.getParameter("actorbirthday");
		String actorwork=request.getParameter("actorwork");
		String actorborned=request.getParameter("actorborned");
		String actorphoto=request.getParameter("actorphoto");
		String actorintroduction=request.getParameter("actorintroduction");

		Actor r=new Actor();
		r.setActorId(actorid);
		r.setActorName(actorname);
		r.setActorSex(actorsex);
		r.setActorSign(actorsign);
		r.setActorBirthday(actorbirthday);
		r.setActorWork(actorwork);
		r.setActorBorned(actorborned);
		r.setActorPhoto(actorphoto);
		r.setActorIntroduction(actorintroduction);
		
		AdminServiceImpl adminServiceImpl=new AdminServiceImpl();
		try {
			//System.out.println(actorid);
			if(adminServiceImpl.updateActor(r))
			{
			//response.getWriter().write("<script type='text/javascript'>alert('修改成功')</script>");
			response.getWriter().write("<script languge='javascript'>alert('修改成功'); window.location.href='JSP/actorSelect.jsp';</script>");

			request.setAttribute("updatemsg", "修改成功");
			//response.sendRedirect("JSP/actorUpdate.jsp");
		    //request.getRequestDispatcher("JSP/actorSelect.jsp").forward(request, response);
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
