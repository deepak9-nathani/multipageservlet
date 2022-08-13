package com.deepak.multipageForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class fileDownload
 */
public class fileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename = request.getParameter("fileName");
		//System.out.println(fileName);
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();    
		String filepath = "C:\\Users\\NeoSOFT\\Desktop\\upload\\";   
		response.setContentType("APPLICATION/OCTET-STREAM");   
		response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
		  
		FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
		            
		int i;   
		while ((i=fileInputStream.read()) != -1) {  
		out.write(i);   
		}   
		fileInputStream.close();   
		out.close();   
		}  

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
