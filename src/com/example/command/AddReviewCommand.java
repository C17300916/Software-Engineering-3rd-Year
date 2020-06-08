package com.example.command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.business.Reviews;
import com.example.exceptions.DaoException;
import com.example.service.AddReviewService;


public class AddReviewCommand implements Command {

	public String execute(HttpServletRequest request, HttpServletResponse repsonse){
		
		AddReviewService reviewService = new AddReviewService();
		String forwardToJsp = "";		

		String movname = request.getParameter("moviename");
		String rating = request.getParameter("rating");
		String content = request.getParameter("content");
		
		int R = Integer.parseInt(rating);

		reviewService.setReview(movname,R,content);
		forwardToJsp = "/AddedReview.jsp";
        
        return forwardToJsp;

	}
}
