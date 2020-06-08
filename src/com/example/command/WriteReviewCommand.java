package com.example.command;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class WriteReviewCommand implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		String forwardToJsp = "";	
		HttpSession session = request.getSession(false);
		
		forwardToJsp = "/WriteReview.jsp";				
			
		return forwardToJsp;
	}

}
