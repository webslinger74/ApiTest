package com.example.dwptest.DAO;

public class DistanceCalculator {

	public static double distance(double lat1, double lat2, double lon1, double lon2) {

		lon1 = Math.toRadians(lon1);
		lon2 = Math.toRadians(lon2);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

// Haversine formula  
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

// Radius of earth. Use 3956 for miles or 6371 for kilometres
		double r = 3956;

		return (c * r);
	}
}
