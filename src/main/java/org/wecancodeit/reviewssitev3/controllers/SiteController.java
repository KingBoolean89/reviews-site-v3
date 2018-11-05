package org.wecancodeit.reviewssitev3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wecancodeit.reviewssitev3.models.Comment;
import org.wecancodeit.reviewssitev3.models.Tag;
import org.wecancodeit.reviewssitev3.repositories.CategoryRepository;
import org.wecancodeit.reviewssitev3.repositories.CommentRepository;
import org.wecancodeit.reviewssitev3.repositories.ReviewRepository;
import org.wecancodeit.reviewssitev3.repositories.TagRepository;

@Controller
public class SiteController {

	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	ReviewRepository reviewRepo;

	@Autowired
	TagRepository tagRepo;

	@Autowired
	CommentRepository commentRepo;

	@GetMapping({ "", "/", "/index" })
	public String home() {
		return "index";
	}

	@GetMapping("/reviews")
	public String getReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@GetMapping("/reviews/{id}")
	public String getReview(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("review", reviewRepo.findById(id).get());
		model.addAttribute("categories", categoryRepo.findAll());
		model.addAttribute("tags", tagRepo.findAll());
		model.addAttribute("comments", commentRepo.findAll());
		return "review";
	}

	@PostMapping("/reviews/{id}/add-comment")
	public String addComment(@PathVariable(value = "id") Long id, String commentName, String commentContent) {
		commentRepo.save(new Comment(commentName, commentContent, reviewRepo.findById(id).get()));
		return "redirect:#";
	}

	@PostMapping("/reviews/{id}/tag")
	public String addTag(@PathVariable(value = "id") Long id, String tagName, Model model) {
		Tag tag = new Tag(tagName);
		reviewRepo.findById(id).get().addTag(tag);
		tagRepo.save(tag);
		return "redirect:/reviews/{id}";
	}

//	@PostMapping("/reviews/{id}/add-tag")
//	public String addTag(@PathVariable(value = "id") Long id, String tagName) {
//		Tag existingTag = tagRepo.findByTagNameIgnoreCase(tagName);
//		if (existingTag == null) {
//			Tag newTag = new Tag(tagName);
//			tagRepo.save(newTag);
//			reviewRepo.findById(id).get().addTag(newTag);
//			reviewRepo.save(reviewRepo.findById(id).get());
//		}
//		if (!reviewRepo.findById(id).get().getTags().contains(existingTag)) {
//			reviewRepo.findById(id).get().addTag(existingTag);
//			reviewRepo.save(reviewRepo.findById(id).get());
//		}
//		return "redirect:#";
//	}
//
//	@PostMapping("/reviews/{id}/remove-tag")
//	public String removeTag(@PathVariable(value = "id") Long id, String tagName) {
//		Tag tagToRemove = tagRepo.findByTagNameIgnoreCase(tagName);
//		reviewRepo.findById(id).get().removeTag(tagToRemove);
//		reviewRepo.save(reviewRepo.findById(id).get());
//		return "redirect:#";
//	}

	@GetMapping("/categories")
	public String getCategories(Model model) {
		model.addAttribute("categories", categoryRepo.findAll());
		return "categories";
	}

	@GetMapping("/categories/{id}")
	public String getCategory(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("category", categoryRepo.findById(id).get());
		model.addAttribute("review", reviewRepo.findAll());
		return "category";
	}

	@GetMapping("/tags/{id}")
	public String getTag(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("tag", tagRepo.findById(id).get());
		model.addAttribute("review", reviewRepo.findAll());
		return "tag";
	}
}
