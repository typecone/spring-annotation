package com.zwj.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	
	@Before
    public void setup() {
		mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
    }
	
	@Test
	public void whenJsonview() throws Exception {
		String temp=mockMvc.perform(MockMvcRequestBuilders.get("/user")
				.param("username", "jojo")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		        .andExpect(MockMvcResultMatchers.status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
		        .andReturn().getResponse().getContentAsString();
		System.out.println(temp);
	}
	
	@Test
	public void whenQuerySuccess() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user2")
				.param("username", "jojo")
				.param("password", "123456")
				.param("age", "123")
				.param("size", "4")
				.param("page", "3")
				.param("sort", "age,desc")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		        .andExpect(MockMvcResultMatchers.status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
	}
	
	@Test
	public void whenPathvariable() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/tom")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		        .andExpect(MockMvcResultMatchers.status().isOk())
		        .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("lisi"));
	}
	
	
	
	
}
