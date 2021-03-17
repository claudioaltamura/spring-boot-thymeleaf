package de.claudioaltamura.springboot.thymeleaf;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = GreetingController.class)
class GreetingControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void homePage() throws Exception {

		mockMvc.perform(get("/index.html"))
				.andExpect(content().string(containsString("greeting")));
	}

	@Test
	void greeting() throws Exception {
		mockMvc.perform(get("/greeting"))
				.andExpect(content().string(containsString("Hello, World!")));
	}

	@Test
	void greetingWithUser() throws Exception {
		mockMvc.perform(get("/greeting").param("name", "Peter"))
				.andExpect(content().string(containsString("Hello, Peter!")));
	}

}
