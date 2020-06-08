package com.example.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.example.business.Reviews;
import com.example.dao.Dao;
import com.example.dao.ReviewDao;
import com.example.exceptions.DaoException;

public class ReviewsService {

	ReviewDao dao = new ReviewDao();
	
	Connection con = null;
	
	
	public List<Reviews> getAllReviews(){
		
		  List<Reviews> reviews = new LinkedList<Reviews>();
		  
		  
	      try {
	            
	    	  con = Dao.getConnection();
	          Statement statement = con.createStatement();
	          ResultSet resultSet = statement.executeQuery("SELECT * FROM REVIEWS ORDER BY ID");

	          Reviews review = null;

	          while (resultSet.next()) {
	        	  review = new Reviews(0, null, null, 0);

	              review.setId(resultSet.getInt("ID"));
	              review.setMovieName(resultSet.getString("MOVIE_NAME"));
	              review.setReviewContent(resultSet.getString("REVIEW_CONTENT"));
	        	  review.setRating(resultSet.getInt("RATING"));
	              

	              System.out.println(review.toString());

	              reviews.add(review);
	          }

	          resultSet.close();
	          statement.close();


	      } catch (SQLException e) {
	          //e.printStackTrace();
	          throw new RuntimeException(e);
	      }

	      return reviews;
		   
	  }
	
}
