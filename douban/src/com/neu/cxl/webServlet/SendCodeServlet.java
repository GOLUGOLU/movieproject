package com.neu.cxl.webServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.cxl.Utils.Utils;

/**
 * Servlet implementation class SendCodeServlet
 */
@WebServlet("/code")
public class SendCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String phone=request.getParameter("phone");
		PrintWriter out=response.getWriter();
		if(phone.trim().equals("")||phone==null)
		{
			//response.sendRedirect("register.html");
			out.println("手机号码格式有误");
			return;
		}
		if(!Pattern.matches("^1[3|5|8]\\d{9}$", phone))
		{
			//response.sendRedirect("register.html");
			out.println("手机号码格式有误");
			return;
		}
		StringBuffer buffer=new StringBuffer();
		Random random=new Random();
		for(int i=0;i<6;i++)
		{
			buffer.append(random.nextInt(10));
		}
		response.setContentType("text/html;charset=utf-8");
		
		if(!Utils.sendcode(phone, buffer.toString()))
		{
			out.println("验证码发送失败");
			
		}
		else
		{
			request.getSession().setAttribute("code", buffer.toString());
			request.getSession().setAttribute("number", phone);
			request.getSession().setAttribute("time", System.currentTimeMillis());
			out.println("验证码发送成功");
			
		}
		out.close();
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
