package com.app.management;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.dao.UserDAO;
@Controller
public class LoginController {
	@RequestMapping("/")
	public ModelAndView login() {
		return new ModelAndView("login","obj", new UserData());
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register","obj", new UserData());
	}
	@RequestMapping(value= "/viewall", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getUsers() {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("user", UserDAO.getUsers());
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}
	@RequestMapping(value= "/submit", method=RequestMethod.POST)
	public ModelAndView getLogin(@ModelAttribute("userData") UserData userData, HttpSession session) {
		if(UserDAO.getLogin(userData.getUserName(), userData.getPassword())) {
			System.out.println("I am inside get Login controller");
			session.setAttribute("sessname",userData.getUserName()); 
			return new ModelAndView("welcomepage","message","Hello there");
		}
		else {
			return new ModelAndView("errorpage","message","Username or password is wrong");
		}
	}
		
	@RequestMapping(value= "/userInsert", method=RequestMethod.POST)
	public String insertUser(@ModelAttribute("userData") UserData userData) {
		userData.setUserName(userData.getUserName());
		userData.setPassword(userData.getPassword());
		UserDAO.insertUser(userData);
		return "welcomepage";
	}
/*	@RequestMapping(value="/search", method=RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getSearchByCity(@ModelAttribute("hotelData") HotelData hotelData) {
		Map<String, Object> map=new HashMap<String, Object>();
		System.out.println("city taken: "+hotelData.getCity());
		map.put("city", UserDAO.hotelsByCity(hotelData.getCity() ) );
		System.out.println("I m inside getSearchByCity");
		
		return new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
	}*/
	//Response Body
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public ModelAndView getSearchByCity(@ModelAttribute("hotelData") HotelData hotelData) {
		ModelAndView model= new ModelAndView();
		System.out.println("city taken: "+hotelData.getCity());
		List<HotelData> hotelData1 =  UserDAO.hotelsByCity(hotelData.getCity());
		model.addObject("hotelData1", hotelData1);
		model.addObject("city", hotelData.getCity());
		model.setViewName("hotels");
		return model;
	}
	@RequestMapping("/booking")
	public ModelAndView booking() {
		ModelAndView model = new ModelAndView();
		List<Room> room = UserDAO.availableRoom();
		System.out.println("booking controller room obj created");
		model.addObject("room", room);
		List<Services> services = UserDAO.availableServices();
		model.addObject("services", services);
		System.out.println("booking controller services obj ceated");
		model.setViewName("bookingRoom");
		model.addObject("roomServices",new RoomServices());
		return model;
	}
	
	@RequestMapping(value="/confirmbooking", method=RequestMethod.POST)
	public ModelAndView proceed(@ModelAttribute("roomServices") RoomServices services) {
		ModelAndView model = new ModelAndView();
		/*RoomServices roomservice = UserDAO.confirmation(roomServices);
		model.addObject("", attributeValue)*/
		return model;
	}
}

