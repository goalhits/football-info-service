package com.sappient.footballinfoservice;

import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class FootballInforControllerTest {
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
	    MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8"));
	    String user = "{\"name\": \"bob\", \"email\" : \"bob@domain.com\"}";
	    mockMvc.perform(MockMvcRequestBuilders.post("/users")
	      .content(user)
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(MockMvcResultMatchers.status().isOk())
	      .andExpect(MockMvcResultMatchers.content()
	        .contentType(textPlainUtf8));
	}
}
