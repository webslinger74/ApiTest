package com.example.dwptest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.example.dwptest.Services.GetPeopleService;
import com.example.dwptest.models.Person;

import io.swagger.annotations.ApiOperation;

@RestController
public class DWPApiController {

	@Autowired
	private GetPeopleService getPeopleService;
	
	
	@ApiOperation(value = "${dwpController.getEndPointValue}",
			notes = "${dwpController.getLondon.api.notes}")
	@GetMapping(path = "/people/london", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public String getAllPeople() {
		String peopleInLondon = getPeopleService.getPeopleInLondon();
		return peopleInLondon;
	}
	
	
	@ApiOperation(value = "${dwpController.getWithinLondonValue}",
			notes = "${dwpController.getWtihinLondon.api.notes}")
	@GetMapping(path = "/people/within50", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Person> getAllPeopleWithin50() {
		List<Person> peopleNearLondon = getPeopleService.getPeopleWithin50OfLondon();
		return peopleNearLondon;
	}

}
