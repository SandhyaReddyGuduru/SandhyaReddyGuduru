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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDAO dao; 
    public RegisterServlet() {
        super();
    dao=new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
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
		String fullname=request.getParameter("fname");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
		User u=new User();
		
		u.setUsername(username);
		u.setPassword(password);
		u.setFullname(fullname);
		u.setEmail(email);
		u.setMobile(mobile);
		
		boolean b=dao.save(u);
	
		if(b)
		{
			System.out.println("welcoooo");
			HttpSession hs=request.getSession();
			hs.setAttribute("uid",username);
			//hs.setAttribute("upassword",password);
			//hs.setAttribute("ufullname",fullname);
			//hs.setAttribute("uemail",email);
			//hs.setAttribute("umobile",mobile);
			response.sendRedirect("home");
		}
		else
		{
			request.setAttribute("error","please try again ");
			doGet(request,response);
		}
	}


	

}
