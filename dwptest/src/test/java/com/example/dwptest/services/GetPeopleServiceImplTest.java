package com.example.dwptest.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.dwptest.DAO.PersonRestClient;
import com.example.dwptest.Services.GetPeopleServiceImpl;
import com.example.dwptest.models.Person;

class GetPeopleServiceImplTest {
	
	@InjectMocks
	GetPeopleServiceImpl getPeopleServiceImpl;
	
	@Mock
	PersonRestClient personRestClient;
	
	List<Person> people = new ArrayList<Person>();

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Person person1 = new Person("1","john", "smith", "john@email.com", "192.0.0.1", "54.001", "0.003");
		Person person2 = new Person("2","jack", "jones", "jack@email2.com", "194.0.0.2", "12.001", "13.023");
		people.add(person1);
		people.add(person2);
	}

	@Test
	void testGetPeopleInLondonNotNull() {
		when(getPeopleServiceImpl.getPeopleInLondon()).thenReturn("the test in service is working and not null");
		String result = getPeopleServiceImpl.getPeopleInLondon();
		assertNotNull(result);
	}
	
	@Test
	void testGetPeopleInLondon() {
		when(getPeopleServiceImpl.getPeopleInLondon()).thenReturn("the test in service is working");
		String result = getPeopleServiceImpl.getPeopleInLondon();
		assertEquals("the test in service is working", result, "the result is correct");
	}

	@Test
	void testGetPeopleWithin50OfLondonNotNull() {
		when(getPeopleServiceImpl.getPeopleWithin50OfLondon()).thenReturn(people);
		List<Person> result = getPeopleServiceImpl.getPeopleWithin50OfLondon();
		assertNotNull(result);
		
	}
	@Test
	void testGetPeopleWithin50OfLondon() {
		when(getPeopleServiceImpl.getPeopleWithin50OfLondon()).thenReturn(people);
		List<Person> result = getPeopleServiceImpl.getPeopleWithin50OfLondon();
		assertEquals("john@email.com", result.get(0).getEmail());
		assertEquals(2, result.size());
		
	}
}
