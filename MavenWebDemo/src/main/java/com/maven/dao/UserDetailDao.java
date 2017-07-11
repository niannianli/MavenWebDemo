package com.maven.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.maven.pojo.UserDetail;

public class UserDetailDao {
	
	public UserDetail validateUser(String username, String password) throws ClassNotFoundException, SQLException{
		// we use jdbc here, but hibernate is better
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_data", "root", "love");
		
		PreparedStatement preparedStatement = connection.prepareStatement
				("select * from user_detail where username = ? and password = ?");
		
		preparedStatement.setString(1, username);
		preparedStatement.setString(2,  password);
		
		UserDetail ud = null;
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()){
			
			ud = new UserDetail();
			ud.setId(resultSet.getInt("id"));			
			ud.setName(resultSet.getString("name"));
			ud.setName(resultSet.getString("username"));
			ud.setName(resultSet.getString("password"));
		}
		
		return ud;
		
	}

}
