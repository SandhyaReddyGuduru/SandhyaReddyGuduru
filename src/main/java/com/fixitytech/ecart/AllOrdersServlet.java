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
 * Servlet implementation class AllOrdersServlet
 */
@WebServlet("/allorders")
public class AllOrdersServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	AdminDAO adminDAO;  
	public AllOrdersServlet() {
        super();
        adminDAO=new AdminDAO();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		HttpSession hs = request.getSession();
		String username=(String)hs.getAttribute("uid");
		List<Order> ordersdetails=adminDAO.getAllOrders(username);
		request.setAttribute("orders",ordersdetails);
		RequestDispatcher rd=request.getRequestDispatcher("allorders.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

}
