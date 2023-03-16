package com.academia.devops;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@WebAppConfiguration
public class SpringbootAplicacionJavaApplicationTests {

	private final static String BASE_URL ="/saludo" ;

	MockMvc mockMvc;

	@Autowired
	private WebApplicationContext applicationContext;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
	}


	@Test
	void testErrorHandlingReturnsBadRequest() throws Exception {

		MvcResult mockMvcT = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		assertEquals(200, mockMvcT.getResponse().getStatus());

	}

	@Test
	void testErrorHandlingReturnsBadRequest2() throws Exception {

		MvcResult mockMvcT = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		assertEquals("Hello from Spring Boot Ricardo!", mockMvcT.getResponse().getContentAsString());

	}
}
