package com.fixitytech.ecart;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/myorders")
public class MyOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	OrderDAO orderDAO;
    public MyOrdersServlet() {
        super();
    orderDAO=new OrderDAO();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession hp=request.getSession();
        
        String username=(String)hp.getAttribute("uid");
        List<Order> orders=orderDAO.getMyOrders(username);
                  hp.setAttribute("ord",orders); 
        
        RequestDispatcher rd=request.getRequestDispatcher("myorders.jsp");
		
        rd.forward(request, response);
        
                   
        
        
	}

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
