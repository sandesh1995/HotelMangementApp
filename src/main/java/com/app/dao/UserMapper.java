/*package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.app.management.UserData;

public class UserMapper implements RowMapper<UserData> {
	   public UserData mapRow(ResultSet rs, int rowNum) throws SQLException {
		      UserData user = new UserData();
		      user.setUserName(rs.getString("userName"));
		      user.setPassword(rs.getString("password"));
		      System.out.println("I m in UserMapper");
		      return user;
		   }
}
*/