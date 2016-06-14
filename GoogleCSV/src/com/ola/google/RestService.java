package com.ola.google;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.SliderUI;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RestService {
	
	public static void main(String[] args) throws Exception {
		List<String> list = ExcelParser.readXLSXFile();
		List<LBSResponse> response = getJSONLBS(list);
		ExcelParser.writeXLSXFileLBS(response);
	}
	
//	public static void main(String[] args) throws IOException {
//		List<String> list = ExcelParser.readXLSXFile();
//		List<String> response = getJSON(list);
//		ExcelParser.writeXLSXFile(response);
//	}
	
/*	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(Arrays.asList("12.97760009765625, 77.5689697265625"));
		List<String> response = getJSON(list);
		for (String string : response) {
			System.out.println(string);
		}
	} 
*/	
/*	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(Arrays.asList("12.97760009765625, 77.5689697265625"));
		List<LBSResponse> response = getJSONLBS(list);
		for (LBSResponse string : response) {
			System.out.println(string);
		}
	} */
	
	private static List<String> getJSON (List<String> latLongList) throws RestClientException {
		List<String> responseList = new ArrayList<String>();
		for (String latlong : latLongList) {
			System.out.println("..." + latlong);
			RestTemplate restTemplate = new RestTemplate();
			 //HashMap<Object, Object> response = restTemplate.getForObject("http://maps.googleapis.com/maps/api/geocode/json?latlng=l", HashMap.class);
			 String response = restTemplate.getForObject("http://maps.googleapis.com/maps/api/geocode/json?latlng=" + latlong, String.class);
			 responseList.add(response);
		}
		return responseList;
	}
	
	private static List<LBSResponse> getJSONLBS (List<String> latLongList) throws Exception {
		List<LBSResponse> responseList = new ArrayList<LBSResponse>();
		for (String latlong : latLongList) {
			RestTemplate restTemplate = new RestTemplate();
			System.out.println("..." + latlong);
			String lat = latlong.substring(0, latlong.indexOf(","));
			String lng = latlong.substring(latlong.indexOf(",")+1);  
			    Thread.sleep(100);
			try{
			LBSResponse response = restTemplate.getForObject("http://stage-lbs-new-937747722.ap-southeast-1.elb.amazonaws.com//locations/reverse_geocode?bypassCityBoundaryCheck=true&lat=" + lat + "&lng=" + lng, LBSResponse.class);
			response.setLatLong(latlong);
			responseList.add(response);
			} catch(Exception e){
				LBSResponse response = new LBSResponse();
				response.setLatLong(latlong);
				responseList.add(response);
				e.printStackTrace();
			}
		}
		return responseList;
	}
}
