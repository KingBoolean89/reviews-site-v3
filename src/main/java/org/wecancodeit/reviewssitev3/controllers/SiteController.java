package org.wecancodeit.reviewssitev3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	
	

}
