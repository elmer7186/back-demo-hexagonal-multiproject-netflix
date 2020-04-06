package com.ceiba.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.demo.entity.MovieDto;
import com.ceiba.demo.testdatabuilder.MovieDtoBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class MovieControllerIntegrationTests {

	private static final String ENDPOINT = "/movies";

	@Autowired
	private MockMvc mockMvc;

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void saveMovieTest() throws Exception {
		// Arrange
		MovieDto movieDto = MovieDtoBuilder.aMovieDto().build();

		// Act - Assert
		this.mockMvc.perform(
			post(ENDPOINT).content(asJsonString(movieDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void geAllMoviesTest() throws Exception {
		// Assert
		this.mockMvc.perform(get(ENDPOINT).accept(MediaType.APPLICATION_JSON)).andDo(print())
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNotEmpty())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Matrix"))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].description").value(
				"is a 1999 science fiction action film written and directed by the Wachowskis. It stars Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano and is the first installment in the Matrix franchise."))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].category.id").value(1))
			.andExpect(
				MockMvcResultMatchers.jsonPath("$[0].category.name").value("Science Fiction"))
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].category.description").value(
				"is a film genre that uses speculative, fictional science-based depictions of phenomena that are not fully accepted by mainstream science, such as extraterrestrial lifeforms, alien worlds, extrasensory perception and time travel"));
	}

	@Test
	public void updateMovie() throws Exception {
		// Arrange
		MovieDto movieDto = MovieDtoBuilder.aMovieDto().withId(1).build();

		// Act
		this.mockMvc.perform(
			post(ENDPOINT).content(asJsonString(movieDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON));

		this.mockMvc.perform(
			put(ENDPOINT).content(asJsonString(movieDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());

		// Assert
		this.mockMvc.perform(get(ENDPOINT).accept(MediaType.APPLICATION_JSON)).andDo(print())
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNotEmpty())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Avengers"));
	}

	@Test
	public void deleteANotExistentMovieTest() throws Exception {
		// Arrange
		MovieDto movieDto = MovieDtoBuilder.aMovieDto().build();

		// Act
		this.mockMvc.perform(
			post(ENDPOINT).content(asJsonString(movieDto)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(print());

		// Assert
		this.mockMvc.perform(delete(ENDPOINT + "/10").accept(MediaType.APPLICATION_JSON))
			.andDo(print())
			.andExpect(status().isNotFound());
	}

	@Test
	public void inactiveExistentMovieTest() throws Exception {
		// Act - Assert
		this.mockMvc.perform(patch(ENDPOINT + "/1/false")
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}

}
