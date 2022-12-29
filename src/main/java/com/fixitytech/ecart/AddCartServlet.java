package com.fixitytech.ecart;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ItemDAO itemDAO;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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
		
		HttpSession sess=request.getSession();
		List<CartItem> cart =(List)sess.getAttribute("cart");
		if(cart==null)
           cart=new Vector<CartItem>();
		String itemId=request.getParameter("id");
		
		boolean isAdded=false;	
		for(CartItem cItem :cart)
		{
			if(cItem.getId()==Integer.parseInt(itemId))
			{		
				cItem.setQuantity(cItem.getQuantity()+1);
			    isAdded=true;
			    break;
			}
			
		}
		if(!isAdded)
		{
		Item item=ItemDAO.getItem(itemId);
		if(item!=null)
		{
			CartItem citem=new CartItem();
			
			citem.setId(item.getId());
			citem.setName(item.getName());
			citem.setPrice(item.getPrice());
			citem.setQuantity(1);
			
			cart.add(citem);
			
			String path=getServletContext().getRealPath("")+"/uploads/";
				File file=new File(path+item.getId());
				if(file.exists()) {
					String names[]=file.list();
			if(names!=null && names.length>0)
			{
					String name=names[0];
				citem.setBase64Image("uploads/"+item.getId()+"/"+name);
			}
			
			
		}
		}
			
			
			System.out.println(itemId);
			sess.setAttribute("cart", cart);
			response.sendRedirect("index");
			
		}}}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	



