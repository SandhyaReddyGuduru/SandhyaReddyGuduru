package com.fixitytech.dao;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddImageServlet
 */
@WebServlet("/addimage")
public class AddImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ItemDAO itemdao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddImageServlet() {
        super();
        itemdao=new ItemDAO();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private static final String UPLOAD_DIR = "uploads";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("addimage.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
       // String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        //InputStream inputStream = null; // input stream of the upload file
        Part filePart = request.getPart("image");

        String path=getServletContext().getRealPath("")+File.separator+UPLOAD_DIR;

       // System.out.println(path);

        File d=new File(path+"/"+id);
        if(!d.exists())
            d.mkdir();

        filePart.write(path+"/"+id+"/"+filePart.getSubmittedFileName());
        doGet(request, response);

		
	}

}
