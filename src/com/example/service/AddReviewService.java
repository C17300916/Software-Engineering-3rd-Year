package com.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.example.business.Reviews;
import com.example.business.User;
import com.example.dao.Dao;
import com.example.dao.AddReviewDao;
import com.example.exceptions.DaoException;

public class AddReviewService {

	AddReviewDao dao = new AddReviewDao();
	
	Connection con = null;
	
	public void setReviews(String moviename, int rating, String content){
		
		dao.setReview(moviename,rating, content);
		
	}
	
	public void setReview(String movname, int rating, String content){
		
		PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
      try {
    	  con = Dao.getConnection();
    	  String query = "INSERT INTO reviews VALUES (null, ?, ?, ?)";
          ps = con.prepareStatement(query);
          ps.setString(1, movname);
          ps.setInt(3, rating);
          ps.setString(2, content);
          

          ps.executeUpdate();

          rs.close();
          ps.close();


      } catch (SQLException e) {
          //e.printStackTrace();
          throw new RuntimeException(e);
      }
	}
	   
}
