package com.ola.google;

import java.util.HashMap;

public class LBSResponse {
	
	private String formatted_address;
	
	private String request_type;
	
	private String pin_code;
	
	private String source;
	
	private String status;
	
	private HashMap city;
	
	private HashMap street;
	
	private HashMap sublocality;
	
	private String latLong;
	
	public HashMap getSublocality() {
		return sublocality;
	}

	public void setSublocality(HashMap sublocality) {
		this.sublocality = sublocality;
	}

	public HashMap getStreet() {
		return street;
	}

	public void setStreet(HashMap street) {
		this.street = street;
	}

	private HashMap locality;
	
	private HashMap landmark;

	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public HashMap getLocality() {
		return locality;
	}

	public void setLocality(HashMap locality) {
		this.locality = locality;
	}

	public HashMap getLandmark() {
		return landmark;
	}

	public void setLandmark(HashMap landmark) {
		this.landmark = landmark;
	} 
	
	public String getRequest_type() {
		return request_type;
	}

	@Override
	public String toString() {
		return "LBSResponse [formatted_address=" + formatted_address + ", request_type=" + request_type + ", pin_code="
				+ pin_code + ", source=" + source + ", status=" + status + ", city=" + city + ", locality=" + locality
				+ ", landmark=" + landmark + "]";
	}

	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}

	public String getPin_code() {
		return pin_code;
	}

	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HashMap getCity() {
		return city;
	}

	public void setCity(HashMap city) {
		this.city = city;
	}

	public String getLatLong() {
		return latLong;
	}

	public void setLatLong(String latLong) {
		this.latLong = latLong;
	}


}
