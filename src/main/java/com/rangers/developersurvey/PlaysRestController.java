package com.rangers.developersurvey;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaysRestController {


	@Autowired
	private JDBC jdbc;

	@RequestMapping(value = "/plays/{date}", method = RequestMethod.GET)
	public List<Play> plays(@PathVariable("date") String date) {
		List<Play> plays = jdbc.getPlays(date);
		return plays;
	}
}
