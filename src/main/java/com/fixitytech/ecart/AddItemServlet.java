package com.fixitytech.ecart;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/additem")
@MultipartConfig(maxFileSize=16177215)
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ItemDAO itemDAO; 
    public AddItemServlet() {
        super();
        itemDAO =new ItemDAO();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rs=request.getRequestDispatcher("additem.jsp");
	     rs.forward(request, response);
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String itemName=request.getParameter("name");
        double itemPrice=Double.parseDouble(request.getParameter("price"));
        byte[] byteArray=null;
        InputStream inputStream=null;
        Part filePart=request.getPart("image");
        if(filePart!=null)
        {
        	System.out.println(filePart.getName());
        inputStream=filePart.getInputStream();
        byte[] buffer= new byte[1000];
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        try
        {
        int temp;
        while((temp=inputStream.read(buffer))!=-1)
        {
            baos.write(buffer,0,temp);
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        byteArray=baos.toByteArray();
        boolean row=itemDAO.additem(id,itemName,itemPrice,byteArray);
        if(row)
        {
            HttpSession hs=request.getSession();
            hs.setAttribute("itemName", itemName);
        }        
        response.sendRedirect("message.jsp");
        request.setAttribute("Success", "Added Successfully");
        }
        else
        {
            request.setAttribute("err", "something went wrong");
            doGet(request, response);
        }

    }
	
}

