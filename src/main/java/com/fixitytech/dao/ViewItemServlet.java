package com.fixitytech.dao;

import java.io.File;
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

import com.fixitytech.ecart.CartItem;
import com.fixitytech.ecart.Item;
import com.fixitytech.ecart.ItemDAO;

/**
 * Servlet implementation class ViewItemServlet
 */
@WebServlet("/viewitem")
public class ViewItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ItemDAO itemDAO;   
    
    public ViewItemServlet() {
        super();
        itemDAO=new ItemDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
         HttpSession hs=request.getSession();
        
         
         List<CartItem> cart =(List)hs.getAttribute("cart");
         if(cart==null)
        cart= new Vector<CartItem>();
         hs.setAttribute("cart", cart);
        
       List<Item> products = itemDAO.getItems();
         String path=getServletContext().getRealPath("")+"/uploads/";
         for(Item item:products)
         {
                     File file=new File(path+item.getId());
                      String names[]=file.list();
         String name=names[0];
                   item.setBase64Image(name);
         }
          request.setAttribute("prs", products);
         RequestDispatcher rs = request.getRequestDispatcher("viewitem.jsp");
         rs.forward(request,response);
          
             }


		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
