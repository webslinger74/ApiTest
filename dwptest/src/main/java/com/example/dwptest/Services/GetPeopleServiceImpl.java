package com.example.dwptest.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dwptest.DAO.PersonRestClient;
import com.example.dwptest.models.Person;

@Service
public class GetPeopleServiceImpl implements GetPeopleService {
	
	@Autowired
	PersonRestClient personRestClient;

	@Override
	public String getPeopleInLondon() {
		String peopleInLondon = personRestClient.getPersonObj();	
		return peopleInLondon;
	}

	@Override
	public List<Person> getPeopleWithin50OfLondon() {
		List<Person> allPeopleWithin50Miles = personRestClient.getPersonWithin50OfLondon();
	
		return allPeopleWithin50Miles;
	}

}
