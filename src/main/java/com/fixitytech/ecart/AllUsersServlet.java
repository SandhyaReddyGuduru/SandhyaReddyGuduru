package com.fixitytech.ecart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AllUsersServlet
 */
@WebServlet("/allusers")
public class AllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminDAO adminDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUsersServlet() {
        super();
        adminDAO=new AdminDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession hs = request.getSession();
		String username=(String)hs.getAttribute("uid");
		List<User> userdetails=adminDAO.getallusers(username);
		request.setAttribute("users", userdetails);
		RequestDispatcher rd=request.getRequestDispatcher("allusers.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
