package com.fixitytech.ecart;

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

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ItemDAO itemDAO;
    public IndexServlet() {
      itemDAO=new ItemDAO();   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession();
		
		List<CartItem> cart =(List)hs.getAttribute("cart");
		if(cart==null)
           cart=new Vector<CartItem>();
		
		hs.setAttribute("cart", cart);
		List<Item> products=itemDAO.getItems();
		String path=getServletContext().getRealPath("")+"/uploads/";
		for(Item item:products)
		{
			File file=new File(path+item.getId());
				String names[]=file.list();
		if(names!=null && names.length>0)
		{
				String name=names[0];
			item.setBase64Image("uploads/"+item.getId()+"/"+name);
		}
		}
		request.setAttribute("prs", products);
		RequestDispatcher rd=request.getRequestDispatcher("indexjsp.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}