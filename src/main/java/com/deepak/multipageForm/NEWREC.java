package com.deepak.multipageForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;  


/**
 * Servlet implementation class NEWREC
 */
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class NEWREC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	   public void init( ){
	      // Get the file location where it would be stored.
	   }
	   
	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, java.io.IOException {
		   int i = 1;
		   //Part filePart = request.getPart("fileUpload");
		    //String fileName = filePart.getSubmittedFileName();
		    for (Part part : request.getParts()) {
		    	String fileName = part.getSubmittedFileName();
		    	System.out.println(fileName);
		      part.write("C:\\Users\\NeoSOFT\\Desktop\\upload\\" + fileName);
		      Cookie ck = new Cookie("fileName"+i, fileName);
		      response.addCookie(ck);
		      i++;
		    }
		    response.getWriter().print("The file uploaded sucessfully.");
		    response.sendRedirect("http://localhost:8081/newMultiPageCrud/index4.jsp");
		    
		    
		   // Check that we have a file upload request
		   
	   }

    

	}

