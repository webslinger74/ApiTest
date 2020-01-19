package com.example.dwptest.Services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.dwptest.models.Person;


@Service
public interface GetPeopleService {
		public String getPeopleInLondon();
		public List<Person> getPeopleWithin50OfLondon();
}
