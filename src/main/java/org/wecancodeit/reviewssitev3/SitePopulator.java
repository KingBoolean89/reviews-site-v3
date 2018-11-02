package org.wecancodeit.reviewssitev3;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.reviewssitev3.models.Category;
import org.wecancodeit.reviewssitev3.models.Review;
import org.wecancodeit.reviewssitev3.repositories.CategoryRepository;
import org.wecancodeit.reviewssitev3.repositories.ReviewRepository;

@Service
public class SitePopulator implements CommandLineRunner {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@Override
	public void run(String... args) throws Exception {

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
				"6.1%", "Great Lakes", lager);
		elliotNess = reviewRepo.save(elliotNess);
		Review lightkeeper = new Review("Light Keeper Blonde Ale", "./images/lightkeeper.jpg", "", "6.6%",
				"Great Lakes", ale);
		lightkeeper = reviewRepo.save(lightkeeper);
		Review commodorePerry = new Review("Commodore Perry IPA", "./images/commodore-perry.jpg", "", "7.7%",
				"Great Lakes", ipa);
		commodorePerry = reviewRepo.save(commodorePerry);

	}

}
