package com.example.dwptest.models;

import java.io.Serializable;
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String first_name;
	private String last_name;
	private String email;
	private String ip_address;
	private String latitude;
	private String longitude;
	
	public Person() {
		
	}

	public Person(String id, String first_name, String last_name, String email, String ip_address, String latitude,
			String longitude) {
		super();

		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.ip_address = ip_address;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "{" + "id"+ ":" + id + " first_name" +":" + first_name + " last_name" +":" + last_name + " email" +":" + email
				+ " ip_address" +":" + ip_address + " latitude" +":" + latitude + " longitude" + ":" + longitude + "}";
	}

}
