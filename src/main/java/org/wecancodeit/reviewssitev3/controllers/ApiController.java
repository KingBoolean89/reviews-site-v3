package org.wecancodeit.reviewssitev3.controllers;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/api/reviews/{id}/tags/add")
	public Collection<Tag> addTag(@PathVariable(value = "id") Long id, @RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String tagName = json.getString("tagName");
		System.out.println(tagName);
		System.out.println(id);
		Review review = reviewRepo.findById(id).get();
		if (tagRepo.findByTagNameIgnoreCase(tagName) == null) {
			Tag tag = new Tag(tagName, review);
			review.addTag(tag);
			tagRepo.save(tag);
		}

		else {
			Tag tag = tagRepo.findByTagNameIgnoreCase(tagName);
			tag.addReview(review);
			review.addTag(tag);
			tagRepo.save(tag);
		}

		return review.getTags();
	}

	@PostMapping("/api/review/{id}/tags/remove")
	public void removeTag(@PathVariable(value = "id") Long id, @RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String tagName = json.getString("tagName");
		Review review = reviewRepo.findById(id).get();
		Tag tag = tagRepo.findByTagNameIgnoreCase(tagName);
		if (tag != null) {
			review.removeTag(tag);
			tag.removeReview(review);
			reviewRepo.save(review);
		}
	}

//	@PostMapping("/api/reviews/{id}/add-tag")
//	public Collection<Tag> addTag(@PathVariable(value = "id") Long id, String tagName) {
//		Tag existingTag = tagRepo.findByTagNameIgnoreCase(tagName);
//		Review review = reviewRepo.findById(id).get();
//		if (existingTag == null) {
//			Tag newTag = new Tag(tagName);
//			tagRepo.save(newTag);
//			review.addTag(newTag);
//			reviewRepo.save(review);
//		}
//		if (!review.getTags().contains(existingTag)) {
//			review.addTag(existingTag);
//			reviewRepo.save(reviewRepo.findById(id).get());
//		}
//		return review.getTags();
//	}
//
//	@PostMapping("/api/reviews/{id}/remove-tag")
//	public Collection<Tag> removeTag(@PathVariable(value = "id") Long id, String tagName) {
//		Tag tagToRemove = tagRepo.findByTagNameIgnoreCase(tagName);
//		Review review = reviewRepo.findById(id).get();
//		review.removeTag(tagToRemove);
//		reviewRepo.save(review);
//		return review.getTags();
//	}

}
