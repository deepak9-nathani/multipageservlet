package com.deepak.multipageForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.tribes.group.Response;
import org.apache.coyote.Request;

/**
 * Servlet implementation class fileSubmit
 */
public class fileSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fileSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 Connection con;
		Cookie ck[] = request.getCookies();
		int user_id = 0;
		String firstName = null;
		int fileLen = 0;
		String lastName = null;
		String Email = null;
		String noOfExp = null;
		String noExpTech = null;
		String lastComp = null;
		ArrayList<String> arr = new ArrayList<>();
		for(Cookie val: ck){
			if(val.getName().equals("firstName")){
				firstName = val.getValue();
				
			}
			if(val.getName().equals("lastName")){
				lastName = val.getValue();
			}
			if(val.getName().equals("Email")){
				Email = val.getValue();
			}
			if(val.getName().equals("noofExp")){
				noOfExp = val.getValue();
			}
			if(val.getName().equals("ExpInTech")){
				noExpTech = val.getValue();
			}
			if(val.getName().equals("lastComp")){
				lastComp = val.getValue();
			}
			if(val.getName().contains("fileLen")){
				fileLen = Integer.parseInt(val.getValue());
				}
			for(int i=1;i<=fileLen;i++){
				if(val.getName().equals("fileName"+i)){
					arr.add(val.getValue());
				}
			}
		}
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/employees","root",">wHsc?jFEs8~qBCb");
			PreparedStatement pst = con.prepareStatement("insert into users(user_firstName,user_lastName,user_Email,user_noofexp,user_expintech,user_lastCompany)values(?,?,?,?,?,?) ");
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, Email);
            pst.setString(4, noOfExp);
            pst.setString(5, noOfExp);
            pst.setString(6, noOfExp);
            int row = pst.executeUpdate();
            pst.close();
			PreparedStatement pst1 = con.prepareStatement("select user_id from users where user_Email=?");
			pst1.setString(1, Email);
			ResultSet row1 = pst1.executeQuery();
			
			while(row1.next()) {
				user_id = Integer.parseInt(row1.getString("user_id"));
			}
			pst1.close();
			System.out.println(user_id);
			for(String x:arr) {
			PreparedStatement pst2 = con.prepareStatement("insert into user_images(user_id,image) VALUES(?,?)");
			pst2.setInt(1, user_id);
			File f = new File("C:\\Users\\NeoSOFT\\Desktop\\upload\\" + x);
			InputStream in = new FileInputStream(f);
			pst2.setBlob(2, in);
			pst2.executeUpdate();
			pst2.close();
			in.close();
			f.delete();
			}
			Cookie firstName1 = new Cookie("firstName","");
			Cookie lastName1 = new Cookie("lastName","");
			Cookie NoofExp = new Cookie("noofExp","");
			Cookie exptech = new Cookie("ExpInTech","");
			Cookie email = new Cookie("Email","");
			Cookie lastComp1 = new Cookie("lastComp","");
			for(int i=1;i<=fileLen;i++) {
				Cookie fileName = new Cookie("fileName"+i,"");
				fileName.setMaxAge(0);
				response.addCookie(fileName);
			}
			firstName1.setMaxAge(0);
			lastName1.setMaxAge(0);
			NoofExp.setMaxAge(0);
			exptech.setMaxAge(0);
			email.setMaxAge(0);
			lastComp1.setMaxAge(0);
			response.addCookie(firstName1);
			response.addCookie(lastName1);
			response.addCookie(NoofExp);
			response.addCookie(exptech);
			response.addCookie(email);
			response.addCookie(lastComp1);
			response.sendRedirect("http://localhost:8081/newMultiPageCrud/index.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
