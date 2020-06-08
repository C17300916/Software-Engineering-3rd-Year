package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.example.business.Reviews;
import com.example.business.User;
import com.example.exceptions.DaoException;


public class AddReviewDao extends Dao {
	
	Connection con = null;

	public void setReview(String movname, int rating, String content){
		
		PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
      try {
    	  con = this.getConnection();
          
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
      }finally {
          try {
              if (rs != null) {
                  rs.close();
              }
              if (ps != null) {
                  ps.close();
              }
              if (con != null) {
                  freeConnection(con);
              }
          } catch (SQLException e) {
        	  throw new RuntimeException(e);
          }
      }
	   
  }
    
}