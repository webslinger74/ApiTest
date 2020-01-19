package com.example.dwptest.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.dwptest.DAO.PersonWebClient;
import com.example.dwptest.models.Person;

public class GetPeopleServiceImplAsync implements GetPeopleService {
	
	@Autowired
	PersonWebClient personWebClient;
	
	@Override
	public String getPeopleInLondon() {
			try {
				personWebClient.getUsersInLondon();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public List<Person> getPeopleWithin50OfLondon() {
		return null;
	}

}
