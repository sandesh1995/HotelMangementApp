package com.app.management;

import java.util.List;

public class RoomServices {
	private int room;
	private int serviceId;
	private List<Services> services;
	
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public List<Services> getServices() {
		return services;
	}
	public void setServices(List<Services> services) {
		this.services = services;
	} 
	
	
	
}
