package com.deepak.multipageForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class fileDelete
 */
public class fileDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cookie ck[] = request.getCookies();
		int fileLen = 0;
		ArrayList<String> arr = new ArrayList<>();
		for(Cookie val: ck){
			if(val.getName().contains("fileLen")){
				fileLen = Integer.parseInt(val.getValue());
				}
			for(int i=1;i<=fileLen;i++){
				if(val.getName().equals("fileName"+i)){
					arr.add(val.getValue());
				}
			}
		}
			File f = null;
			for(String s:arr) {
			f = new File("C:\\Users\\NeoSOFT\\Desktop\\upload\\"+ s);
			if(f.delete())
			{
				System.out.println("success");
			}
			}
			Cookie firstName = new Cookie("firstName","");
			Cookie lastName = new Cookie("lastName","");
			Cookie NoofExp = new Cookie("noofExp","");
			Cookie exptech = new Cookie("ExpInTech","");
			Cookie email = new Cookie("Email","");
			Cookie lastComp = new Cookie("lastComp","");
			for(int i=1;i<=fileLen;i++) {
				Cookie fileName = new Cookie("fileName"+i,"");
				fileName.setMaxAge(0);
				response.addCookie(fileName);
			}
			firstName.setMaxAge(0);
			lastName.setMaxAge(0);
			NoofExp.setMaxAge(0);
			exptech.setMaxAge(0);
			email.setMaxAge(0);
			lastComp.setMaxAge(0);
			response.addCookie(firstName);
			response.addCookie(lastName);
			response.addCookie(NoofExp);
			response.addCookie(exptech);
			response.addCookie(email);
			response.addCookie(lastComp);
			
			
		
		response.sendRedirect("http://localhost:8081/newMultiPageCrud/index.jsp");
	}

}
