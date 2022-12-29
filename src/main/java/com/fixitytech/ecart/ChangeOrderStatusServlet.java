package com.fixitytech.ecart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeOrderStatusServlet
 */
@WebServlet("/changeStatus")
public class ChangeOrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderDAO orderdao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeOrderStatusServlet() {
        super();
        orderdao=new OrderDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String status=request.getParameter("status");
		int oid=Integer.parseInt(request.getParameter("orderId"));
		if(status.equals("accept"))
			orderdao.changeStatus(oid,1);
		else
			orderdao.changeStatus(oid,-1);
		
		response.sendRedirect("admin");
	
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
