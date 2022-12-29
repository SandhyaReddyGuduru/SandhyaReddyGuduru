package com.fixitytech.ecart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		rd.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username=request.getParameter("uname");
		String password=request.getParameter("upassword");
		String cont=request.getParameter("c");
		boolean b=new UserDAO().validate(username, password);
		if(b)
		{
			HttpSession hs=request.getSession();
			hs.setAttribute("uid",username);
		
			if(cont!=null && cont.length()>0)
			response.sendRedirect("cont");
			else
				response.sendRedirect("login");
		}
		else if (username.equals("admin")&& password.equals("admin")) {
			response.sendRedirect("admin.jsp");
		}
		else {
		
			
			request.setAttribute("err","invalid username or password");
			doGet(request,response);
		}
}}
	
	


