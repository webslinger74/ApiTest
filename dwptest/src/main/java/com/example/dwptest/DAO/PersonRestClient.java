package com.example.dwptest.DAO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.example.dwptest.models.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PersonRestClient {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.resource.path}")
	private String RESOURCE_PATH;
		
	@Value("${restProducer.host}")
	private String REST_API_HOST;
	
	@Value("${api.resource.path.users}")
	private String USERS;
		public PersonRestClient() {
		}
		

	public String getPersonObj (){
		ResponseEntity<String> entity = restTemplate
				.getForEntity(REST_API_HOST + RESOURCE_PATH, String.class);
		String result = entity.getBody();
		return result;
	}
	

	public List<Person> getPersonWithin50OfLondon() {
		ResponseEntity<String> entity = restTemplate
				.getForEntity(REST_API_HOST + USERS, String.class);
		String result = entity.getBody();

		ObjectMapper mapper = new ObjectMapper();
		Double LondonLat = 51.509865;
		Double LondonLong = -0.11892;
		List<Person> allpeople = null;
		try {
			allpeople = Arrays.asList(mapper.readValue(result, Person[].class));
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		List<Person> allPeopleWithin50Miles = allpeople.stream()
			.filter((person) -> {
				Double distance = DistanceCalculator.distance(LondonLat, Double.parseDouble(person.getLatitude()),
																LondonLong, Double.parseDouble(person.getLongitude()));
				 return distance < 50;
				})
			.collect(Collectors.toList());
		return allPeopleWithin50Miles;
	}
	 	
}
