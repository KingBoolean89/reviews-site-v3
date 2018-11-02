package org.wecancodeit.reviewssitev3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

//	@Autowired
//	TagRepository tagRepo;

//	@Autowired
//	CommentRepository commentRepo;

	@GetMapping({ "", "/", "/index" })
	public String home() {
		return "index";
	}

	@GetMapping("/reviews")
	public String getReviews(Model model) {
		model.addAttribute("reviews", reviewRepo.findAll());
		return "reviews";
	}

	@RequestMapping("/reviews/{id}")
	public String getContact(@PathVariable(value = "id") Long id, Model model) {
		model.addAttribute("review", reviewRepo.findById(id).get());
		model.addAttribute("categories", categoryRepo.findAll());
		return "review";
	}

}
