package com.example.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;
import com.example.service.UserService;

public class ViewUserProfileCommand implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		UserService userService = new UserService();
		String forwardToJsp = "";	
		HttpSession session = request.getSession(false);
		
		
		User user = null;
		if(session != null){
		    user = (User) session.getAttribute("user");
		}
		 
		session.setAttribute("users", user);
		
		forwardToJsp = "/viewProfile.jsp";				
			
		return forwardToJsp;
	}

}