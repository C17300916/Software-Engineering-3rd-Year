package com.example.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.example.business.User;
import com.example.dao.Dao;
import com.example.dao.UserDao;
import com.example.exceptions.DaoException;

public class UserService {

	UserDao dao = new UserDao();
	
	Connection con = null;

	
	public User login(String username, String password){
		
		User u = null;
		try {			
			u = dao.findUserByUsernamePassword(username, password);
		} 
		catch (DaoException e) {
			e.printStackTrace();
		}
		return u;
		
	}
	
	
	public List<User> getAllUsers(){
		
		  List<User> users = new LinkedList<User>();
		  
		  
	      try {
	            
	    	  con = Dao.getConnection();
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
