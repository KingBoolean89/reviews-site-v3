package org.wecancodeit.reviewssitev3;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviewssitev3.models.Category;
import org.wecancodeit.reviewssitev3.models.Review;
import org.wecancodeit.reviewssitev3.models.Tag;
import org.wecancodeit.reviewssitev3.repositories.CategoryRepository;
import org.wecancodeit.reviewssitev3.repositories.ReviewRepository;
import org.wecancodeit.reviewssitev3.repositories.TagRepository;

@Component
public class SitePopulator implements CommandLineRunner {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;
	@Resource
	TagRepository tagRepo;

	@Override
	public void run(String... args) throws Exception {
		
		//Tags
		Tag tag1 = tagRepo.save(new Tag("Hoppy"));
		Tag tag2 = tagRepo.save(new Tag("Bold"));
		Tag tag3 = tagRepo.save(new Tag("Bitter"));
		Tag tag4 = tagRepo.save(new Tag("Fruity"));
		Tag tag5 = tagRepo.save(new Tag("Rich"));
		Tag tag6 = tagRepo.save(new Tag("Malt"));
		Tag tag7 = tagRepo.save(new Tag("Caramel"));
		Tag tag8 = tagRepo.save(new Tag("Citrus"));
		Tag tag9 = tagRepo.save(new Tag("Pine"));
		Tag tag10 = tagRepo.save(new Tag("Crisp"));
		Tag tag11 = tagRepo.save(new Tag("Full-bodied"));
		Tag tag12 = tagRepo.save(new Tag("Wheat"));
//		tag1 = tagRepo.save(tag1);
//		tag2 = tagRepo.save(tag2);
//		tag3 = tagRepo.save(tag3);
//		tag4 = tagRepo.save(tag4);
//		tag5 = tagRepo.save(tag5);
//		tag6 = tagRepo.save(tag6);
//		tag7 = tagRepo.save(tag7);
//		tag8 = tagRepo.save(tag8);
//		tag9 = tagRepo.save(tag9);
//		tag10 = tagRepo.save(tag10);
//		tag11 = tagRepo.save(tag11);
//		tag12 = tagRepo.save(tag12);
		
		

		// Categories
		Category lager = new Category("Lager");
		lager = categoryRepo.save(lager);
		Category ale = new Category("Ale");
		ale = categoryRepo.save(ale);
		Category ipa = new Category("IPA");
		ipa = categoryRepo.save(ipa);

		// Reviews
		Review elliotNess = new Review("Elliot Ness Amber Lager", "./images/elliot-ness.jpg",
				"Lorem ipsum dolor amet forage paleo humblebrag art party cred bespoke squid pok pok mlkshk iPhone tote bag PBR&B thundercats cloud bread hammock. Williamsburg forage direct trade, irony church-key hell of readymade roof party microdosing. Pabst meh vinyl locavore lo-fi pour-over, skateboard polaroid swag viral tousled pok pok. Franzen selvage fashion axe 3 wolf moon.",
				"6.1%", "Great Lakes", lager, tag1,tag2,tag3,tag4);
		elliotNess = reviewRepo.save(elliotNess);
		Review lightkeeper = new Review("Light Keeper Blonde Ale", "./images/lightkeeper.jpg", "", "6.6%",
				"Great Lakes", ale,tag5,tag6,tag7,tag8);
		lightkeeper = reviewRepo.save(lightkeeper);
		Review commodorePerry = new Review("Commodore Perry IPA", "./images/commodore-perry.jpg", "", "7.7%",
				"Great Lakes", ipa,tag9,tag10,tag11,tag12);
		commodorePerry = reviewRepo.save(commodorePerry);

	}

}
