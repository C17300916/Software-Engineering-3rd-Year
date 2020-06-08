package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.example.business.User;
import com.example.exceptions.DaoException;


public class UserDao extends Dao {
	
	Connection con = null;

    public User findUserByUsernamePassword(String uname, String pword) throws DaoException {

     
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM USER WHERE USERNAME = ? AND PASSWORD = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, pword);
            
            rs = ps.executeQuery();
            if (rs.next()) {
            	int userId = rs.getInt("ID");
                String username = rs.getString("USERNAME");
                String password = rs.getString("PASSWORD");
                String lastname = rs.getString("LAST_NAME");
                String firstname = rs.getString("FIRST_NAME");
                u = new User(userId, firstname, lastname, username, password);
            }
        } catch (SQLException e) {
            throw new DaoException("findUserByUsernamePassword " + e.getMessage());
        } finally {
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
                throw new DaoException("findUserByUsernamePassword" + e.getMessage());
            }
        }
        return u;     // u may be null 
    }
    
    
  public List<User> getAllUsers(){
	
	  List<User> users = new LinkedList<User>();
	  
	  
      try {
    	  
          Statement statement = con.createStatement();
          ResultSet resultSet = statement.executeQuery("SELECT * FROM USER ORDER BY ID");

          User user = null;

          while (resultSet.next()) {
              user = new User(0, null, null, null, null);

              user.setId(resultSet.getInt("ID"));
              user.setFirstName(resultSet.getString("FIRST_NAME"));
              user.setLastName(resultSet.getString("LAST_NAME"));
        	  user.setUsername(resultSet.getString("USERNAME"));
              user.setPassword(resultSet.getString("PASSWORD"));
              

              System.out.println(user.toString());

              users.add(user);
          }

          resultSet.close();
          statement.close();


      } catch (SQLException e) {
          //e.printStackTrace();
          throw new RuntimeException(e);
      }

      return users;
	   
  }
    
}