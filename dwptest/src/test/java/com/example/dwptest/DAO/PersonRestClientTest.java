package com.example.dwptest.DAO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.List;
import org.json.CDL;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.example.dwptest.models.Person;

@SpringBootTest
class PersonRestClientTest {

	@Autowired
	@InjectMocks
	PersonRestClient personRestClient;

	@Autowired
	@MockBean
	RestTemplate restTemplate;

	@Test
	void testGetPersonObj() {
		Person person1 = new Person("1", "john", "smith", "john@email.com", "192.0.0.1", "54.001", "0.003");
		when(restTemplate.getForEntity("https://bpdts-test-app.herokuapp.com/city/London/users", String.class))
				.thenReturn(new ResponseEntity<String>(person1.toString(), HttpStatus.OK));

		String result = personRestClient.getPersonObj();
		assertEquals(person1.toString(), result);
	}

	@Test
	void testGetPersonWithin50OfLondon() {

		String string = "id, first_name, last_name, email, ip_address, latitude, longitude \n"
				+ "1, john, smith, john@email.com, 192.0.0.1, 10.5001, 0.003 \n"
				+ "2, john2, smith2, john@email2.com, 192.0.0.1, 51.005, 0.003";

		JSONArray mockResult = CDL.toJSONArray(string);

		when(restTemplate.getForEntity("https://bpdts-test-app.herokuapp.com/users", String.class))
				.thenReturn(new ResponseEntity<String>(mockResult.toString(), HttpStatus.OK));

		List<Person> actualResult = personRestClient.getPersonWithin50OfLondon();
		assertEquals(mockResult.getJSONObject(1).get("id"), actualResult.get(0).getId());
		assertEquals(mockResult.getJSONObject(1).get("first_name"), actualResult.get(0).getFirst_name());
		assertTrue(actualResult.get(0).getEmail().toString().equals("john@email2.com"));
	}

}
