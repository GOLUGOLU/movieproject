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
 * Servlet implementation class DeleteActorServlet
 */
@WebServlet("/DeleteActorServlet")
public class DeleteActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteActorServlet() {
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
		AdminServiceImpl adminServiceImpl=new AdminServiceImpl();
		Actor r=new Actor();
		r.setActorId(actorid);
		try {
			if(adminServiceImpl.deleteActor(r))
			{
				request.setAttribute("deletemsg", "删除成功");
				response.getWriter().write("<script languge='javascript'>alert('删除成功'); window.location.href='JSP/actorSelect.jsp';</script>");
				
			}
			else
			{
				request.setAttribute("deletemsg", "删除失败");
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
