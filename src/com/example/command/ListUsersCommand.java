package com.example.command;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.User;
import com.example.service.UserService;

public class ListUsersCommand implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		UserService userService = new UserService();
		String forwardToJsp = "";	
		HttpSession session = request.getSession(false);
		
		List<User> userlist = new LinkedList<User>();
		
		userlist = userService.getAllUsers();
		  
		session.setAttribute("users", userlist);
		
		forwardToJsp = "/viewList.jsp";				
			
		return forwardToJsp;
	}

}
