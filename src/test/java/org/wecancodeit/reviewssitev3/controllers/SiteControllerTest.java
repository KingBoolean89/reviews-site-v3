package org.wecancodeit.reviewssitev3.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.wecancodeit.reviewssitev3.models.Category;
import org.wecancodeit.reviewssitev3.models.Review;
import org.wecancodeit.reviewssitev3.repositories.CategoryRepository;
import org.wecancodeit.reviewssitev3.repositories.ReviewRepository;
import org.wecancodeit.reviewssitev3.repositories.TagRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(SiteController.class)

public class SiteControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CategoryRepository categoryRepo;
	@MockBean
	private ReviewRepository reviewRepo;
	@MockBean
	private TagRepository tagRepo;

	@Mock
	Review reviewOne;

	@Mock
	Category categoryOne;

	@Test
	public void shouldBeOkayWhenAccessingIndex() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnTemplateWhenAccessingIndex() throws Exception {
		mockMvc.perform(get("/")).andExpect(view().name("index"));
	}

	@Test
	public void shouldBeOkayWhenAccessingReviews() throws Exception {
		mockMvc.perform(get("/reviews")).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnTemplateWhenAccessingReviews() throws Exception {
		mockMvc.perform(get("/reviews")).andExpect(view().name("reviews"));
	}

	@Test
	public void shouldBeOkayWhenAccessingReview() throws Exception {
		when(reviewRepo.findById(1L).get()).thenReturn(reviewOne);
		mockMvc.perform(get("/review/1")).andExpect(status().isOk());
	}
}
