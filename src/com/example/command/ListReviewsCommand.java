package com.example.command;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Reviews;
import com.example.service.ReviewsService;

public class ListReviewsCommand implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		ReviewsService reviewService = new ReviewsService();
		String forwardToJsp = "";	
		HttpSession session = request.getSession(false);
		
		List<Reviews> reviewList = new LinkedList<Reviews>();
		
		reviewList = reviewService.getAllReviews();
		  
		session.setAttribute("reviews", reviewList);
		
		forwardToJsp = "/ReviewsList.jsp";				
			
		return forwardToJsp;
	}

}
