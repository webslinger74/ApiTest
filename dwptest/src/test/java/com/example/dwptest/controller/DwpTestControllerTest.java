package com.example.dwptest.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.dwptest.Services.GetPeopleServiceImpl;
import com.example.dwptest.controllers.DWPApiController;
import com.example.dwptest.models.Person;

class DwpTestControllerTest {
	
	
	@InjectMocks
	DWPApiController dwpApiController;
	
	@Mock
	GetPeopleServiceImpl getPeopleServiceImpl;
	
	private List<Person> people = new ArrayList<Person>();

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		Person person1 = new Person("1","john", "smith", "john@email.com", "192.0.0.1", "54.001", "0.003");
		Person person2 = new Person("2","jack", "jones", "jack@email2.com", "194.0.0.2", "12.001", "13.023");
		people.add(person1);
		people.add(person2);
	}

	@Test
	void testGetAllPeopleNotNull() {
		when(getPeopleServiceImpl.getPeopleInLondon()).thenReturn("the test is working");
		String result = dwpApiController.getAllPeople();
		assertNotNull(result);
	}
	

	@Test
	void testGetAllPeople() {
		when(getPeopleServiceImpl.getPeopleInLondon()).thenReturn("the test is working");
		String result = dwpApiController.getAllPeople();
		assertEquals("the test is working", result);
	}
	
	@Test
	void  testgetAllPeopleWithin50NotNull() {
		
		when(getPeopleServiceImpl.getPeopleWithin50OfLondon()).thenReturn(people);
		
		List<Person> peopleNearLondon = dwpApiController.getAllPeopleWithin50();
		assertNotNull(peopleNearLondon);
	}
	
	@Test
	void  testgetAllPeopleWithin50() {
		
		when(getPeopleServiceImpl.getPeopleWithin50OfLondon()).thenReturn(people);
		
		List<Person> peopleNearLondon = dwpApiController.getAllPeopleWithin50();
		assertEquals("john", peopleNearLondon.get(0).getFirst_name());
		assertEquals(2, peopleNearLondon.size());
	}
	
	
	
	
	
	
	
	
	

}
