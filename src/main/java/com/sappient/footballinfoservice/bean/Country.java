package com.sappient.footballinfoservice.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {
	@JsonProperty("country_id")
	private String id;
	@JsonProperty("country_name")
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
