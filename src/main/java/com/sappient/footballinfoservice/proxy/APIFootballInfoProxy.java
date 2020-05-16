package com.sappient.footballinfoservice.proxy;

import java.util.List;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sappient.footballinfoservice.bean.Country;

//@FeignClient(name="APIFootballInfoProxy", url= "https://apiv2.apifootball.com")
public interface APIFootballInfoProxy {
	
	@GetMapping("/api")
	public List<Country> getCountries(@RequestParam String action, @RequestParam("APIkey") String apiKey);
}
