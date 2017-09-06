/*package com.app.dao;

import com.app.management.UserData;

public interface UserDAO {
	
	public UserData getUser(String userName);
}
*/
package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.app.management.HotelData;
import com.app.management.Room;
import com.app.management.Services;
import com.app.management.UserData;

@Repository
public class UserDAO{
	@Autowired
	private static JdbcTemplate jdbcTemplate;
	
	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		UserDAO.jdbcTemplate = jdbcTemplate;
	}



	public static List<UserData> getUsers(){
		return jdbcTemplate.query("select * from login", new RowMapper<UserData> () {
			
			public UserData mapRow(ResultSet rs, int rowNum) throws SQLException {
			      UserData userData = new UserData();
			      userData.setUserName(rs.getString("userName"));
			      userData.setPassword(rs.getString("password"));
			      System.out.println("I m in Mapper");
			      return userData;
			   }
		});
	}
	public static Boolean getLogin(String username, String password) {
		System.out.println("I am inside getLogin function and class UserDAO");
		UserData userData = jdbcTemplate.queryForObject("select * from login where username=?",new Object[] {username} , new RowMapper<UserData> () {
			
			public UserData mapRow(ResultSet rs, int rowNum) throws SQLException {
			      UserData userData = new UserData();
			      userData.setUserName(rs.getString("userName"));
			      userData.setPassword(rs.getString("password"));
			      System.out.println("I m in Mapper");
			      return userData;
			   }
		});
		if(password.equals(userData.getPassword() ) ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static Boolean insertUser(UserData userData) {
		int ins = jdbcTemplate.update("insert into login(username,password) values(?,?)", new Object[] {userData.getUserName(), userData.getPassword()});
		if(ins > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static List<HotelData> hotelsByCity(String city){
		System.out.println("inside search function in UserDAO");
		return jdbcTemplate.query("select * from hotel where city=?", new RowMapper<HotelData> () {
			public HotelData mapRow(ResultSet rs, int rowNum) throws SQLException {
				HotelData hotelData= new HotelData();
				hotelData.setHotelid(rs.getInt("hotelid"));
				hotelData.setHotelname(rs.getString("hotelname"));
				hotelData.setCity(rs.getString("city"));
				hotelData.setRating(rs.getInt("rating"));
				System.out.println("inside Hotel rowMapper");
				return hotelData;
			}
		},city);
	
	}
	public static List<Room> availableRoom(){
		boolean status= true;
		System.out.println("inside search function in UserDAO availableRoom");
		return jdbcTemplate.query("select * from room where availability=?", new RowMapper<Room> () {
			public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
				Room room= new Room();
				room.setRoomId(rs.getInt("roomid"));
				room.setRoomType(rs.getString("roomtype"));
				room.setCapacity(rs.getInt("capacity"));
				room.setPrice(rs.getInt("price"));
				room.setAvailability(rs.getBoolean("availability"));
				System.out.println("inside Room rowMapper");
				return room;
			}
		},status);

	}
	public static List<Services> availableServices(){
		System.out.println("inside UserDAO.availableServices");
		return jdbcTemplate.query("select * from services", new RowMapper<Services> () {
			
			public Services mapRow(ResultSet rs, int rowNum) throws SQLException {
				  Services services = new Services();
				  services.setServiceId(rs.getInt("serviceid"));
				  services.setServiceType(rs.getString("servicetype"));
				  services.setPrice(rs.getInt("price"));
			      System.out.println("I m in Services Mapper");
			      return services;
			   }
		});
	}
}
