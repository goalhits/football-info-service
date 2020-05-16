package com.sappient.footballinfoservice;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sappient.footballinfoservice.bean.Country;
import com.sappient.footballinfoservice.bean.League;

@RestController
public class FootballInforController {	
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("/api/country")
	public List<Country> getCountries() {
		Map<String, String> queryParameters = new HashMap<String, String>();
		queryParameters.put("action", "get_countries");
		String url = prepareUrl(queryParameters);
		ResponseEntity<Country[]> responseEntity = new RestTemplate().getForEntity(url, Country[].class);
		return Arrays.asList(responseEntity.getBody());
	}
	
	@GetMapping("/api/league")
	public List<League> getLeague(@RequestParam("country_id") String countryId) {
		Map<String, String> queryParameters = new HashMap<String, String>();
		queryParameters.put("action", "get_leagues");
		queryParameters.put("countryId", countryId);
		String url = prepareUrl(queryParameters);
		ResponseEntity<League[]> responseEntity = new RestTemplate().getForEntity(url, League[].class);
		return Arrays.asList(responseEntity.getBody());
	}
	
	@GetMapping("/api/team")
	public List<League> getTeams(@RequestParam("country_id") String countryId) {
		Map<String, String> queryParameters = new HashMap<String, String>();
		queryParameters.put("action", "get_leagues");
		queryParameters.put("countryId", "countryId");
		String url = prepareUrl(queryParameters);
		ResponseEntity<League[]> responseEntity = new RestTemplate().getForEntity(url, League[].class);
		return Arrays.asList(responseEntity.getBody());
	}
	
	@GetMapping("/api/country/{id}")
	public List<Country> getTeam(@PathVariable String id) {
		Map<String, String> queryParameters = new HashMap<String, String>();
		queryParameters.put("action", "get_countries");
		String url = prepareUrl(queryParameters);
		ResponseEntity<Country[]> responseEntity = new RestTemplate().getForEntity(url, Country[].class);
		return Arrays.asList(responseEntity.getBody());
	}
	
	@GetMapping("/api/standing")
	public List<League> getStanding(@RequestParam("country_id") String countryId) {
		Map<String, String> queryParameters = new HashMap<String, String>();
		queryParameters.put("action", "get_leagues");
		queryParameters.put("countryId", "countryId");
		String url = prepareUrl(queryParameters);
		ResponseEntity<League[]> responseEntity = new RestTemplate().getForEntity(url, League[].class);
		return Arrays.asList(responseEntity.getBody());
	}
	
	private String prepareUrl(Map<String, String> queryParameters) {
		StringBuilder builder = new StringBuilder();
		builder.append(configuration.getApiUrl());
		builder.append("?APIkey=9bb66184e0c8145384fd2cc0f7b914ada57b4e8fd2e4d6d586adcc27c257a978");
		for(Map.Entry<String, String> entry : queryParameters.entrySet()) {
			builder.append("&");
			builder.append(entry.getKey());
			builder.append("=");
			builder.append(entry.getValue());
		}
		return builder.toString();
	}
}
