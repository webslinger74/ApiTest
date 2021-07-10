package com.example.dwptest.DAO;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DistanceCalculatorTest {

	@Test
	void testDistanceSamePlace() {
		Double result = DistanceCalculator.distance(50.00, 50.00, -5.00, -5.00);
		assertTrue(result == 0.0);
	}
	@Test
	void testDistanceLatitude() {
		Double result = DistanceCalculator.distance(49.00, 50.00, -5.00, -5.00);
		assertFalse(result == 69.04522520889621);
	}
	@Test
	void testDistanceLongitude() {
		Double result = DistanceCalculator.distance(50.00, 50.00, -0.00, -1.00);
		assertTrue(result == 44.38108470714215);
	}
}
