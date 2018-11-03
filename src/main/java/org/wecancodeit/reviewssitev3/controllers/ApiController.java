package org.wecancodeit.reviewssitev3.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.wecancodeit.reviewssitev3.models.Category;
import org.wecancodeit.reviewssitev3.models.Review;
import org.wecancodeit.reviewssitev3.models.Tag;
import org.wecancodeit.reviewssitev3.repositories.CategoryRepository;
import org.wecancodeit.reviewssitev3.repositories.ReviewRepository;
import org.wecancodeit.reviewssitev3.repositories.TagRepository;

@RestController
public class ApiController {

	@Autowired
	ReviewRepository reviewRepo;
	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	TagRepository tagRepo;

	@GetMapping("/api/reviews")
	public Iterable<Review> getReviews() {
		return reviewRepo.findAll();
	}

	@GetMapping("/api/reviews/{id}")
	public Review getReview(@PathVariable(value = "id") Long id) {
		return reviewRepo.findById(id).get();
	}

	@GetMapping("/api/categories")
	public Iterable<Category> getCategories() {
		return categoryRepo.findAll();
	}

	@GetMapping("/api/category/{id}")
	public Category getCategory(@PathVariable(value = "id") Long id) {
		return categoryRepo.findById(id).get();
	}

	@GetMapping("/api/tags")
	public Iterable<Tag> getTags() {
		return tagRepo.findAll();
	}

	@GetMapping("/api/tags/{name}")
	public Tag getTag(@PathVariable(value = "name") String tagName) {
		return tagRepo.findByTagNameIgnoreCase(tagName);
	}

	@GetMapping("/api/tags/{name}/reviews")
	public Collection<Review> showTagReviews(@PathVariable(value = "name") String tagName) {
		return tagRepo.findByTagNameIgnoreCase(tagName).getReviews();
	}

}
