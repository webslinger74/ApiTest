package com.example.dwptest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.dwptest.Services.GetPeopleServiceImpl;
import com.example.dwptest.controllers.DWPApiController;
import com.example.dwptest.models.Person;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

@WebMvcTest(DWPApiController.class)
class DwpTestControllerMockMvcWebLayerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	GetPeopleServiceImpl getPeopleServiceImpl;

	@Test
	void testGetAllPeople() throws Exception {

		when(getPeopleServiceImpl.getPeopleInLondon()).thenReturn("the mock people returned from the api call");
		this.mockMvc.perform(get("/people/london")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("the mock people returned from the api call")));

	}

	@Test
	void testGetAllPeopleWithin50() throws Exception {

		List<Person> people = new ArrayList<Person>();
		Person person1 = new Person("1", "john", "smith", "john@email.com", "192.0.0.1", "54.001", "0.003");
		Person person2 = new Person("2", "jack", "jones", "jack@email2.com", "194.0.0.2", "12.001", "13.023");
		people.add(person1);
		people.add(person2);
		
		when(getPeopleServiceImpl.getPeopleWithin50OfLondon()).thenReturn(people);
		this.mockMvc.perform(get("/people/within50")).andDo(print()).andExpect(status().isOk())

			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$[1].id", is("2")))
			.andExpect(jsonPath("$[0].ip_address", is("192.0.0.1")));
	}


}
