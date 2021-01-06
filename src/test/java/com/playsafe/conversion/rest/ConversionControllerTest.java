package com.playsafe.conversion.rest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ConversionControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testKtoc() throws Exception {
		this.mockMvc.perform(post("/conversions/ktoc").contentType(MediaType.APPLICATION_JSON).content("0".getBytes())).andExpect(status().isOk())
				.andExpect(content().string(containsString("-273.15")));
	}
	@Test
	public void testCtok() throws Exception {
		this.mockMvc.perform(post("/conversions/ctok").contentType(MediaType.APPLICATION_JSON).content("0".getBytes())).andExpect(status().isOk())
				.andExpect(content().string(containsString("273.15")));
	}
	@Test
	public void testMtok() throws Exception {
		this.mockMvc.perform(post("/conversions/mtok").contentType(MediaType.APPLICATION_JSON).content("1".getBytes())).andExpect(status().isOk())
				.andExpect(content().string(containsString("1.609")));
	}
	@Test
	public void testKtom() throws Exception {
		this.mockMvc.perform(post("/conversions/ktom").contentType(MediaType.APPLICATION_JSON).content("1".getBytes())).andExpect(status().isOk())
				.andExpect(content().string(containsString("0.6215040397762586")));
	}
	
}
