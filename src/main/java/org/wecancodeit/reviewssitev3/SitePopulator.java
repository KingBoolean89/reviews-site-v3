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

		// Tags
//		Tag hoppy = new Tag("Hoppy");
//		Tag bold = new Tag("Bold");
//		Tag bitter = new Tag("Bitter");
//		Tag fruity = new Tag("Fruity");
//		Tag rich = new Tag("Rich");
//		Tag malty = new Tag("Malty");
//		Tag caramel = new Tag("Caramel");
//		Tag citrus = new Tag("Citrus");
//		Tag pine = new Tag("Pine");
//		Tag crisp = new Tag("Crisp");
//		Tag fullBodied = new Tag("Full-Bodied");
//		Tag wheat = new Tag("Wheat");
//		hoppy = tagRepo.save(hoppy);
//		bold = tagRepo.save(bold);
//		bitter = tagRepo.save(bitter);
//		fruity = tagRepo.save(fruity);
//		rich = tagRepo.save(rich);
//		malty = tagRepo.save(malty);
//		caramel = tagRepo.save(caramel);
//		citrus = tagRepo.save(citrus);
//		pine = tagRepo.save(pine);
//		crisp = tagRepo.save(crisp);
//		fullBodied = tagRepo.save(fullBodied);
//		wheat = tagRepo.save(wheat);

		// Categories
		Category lager = new Category("Lager");
		Category ale = new Category("Ale");
		Category ipa = new Category("IPA");
		lager = categoryRepo.save(lager);
		ale = categoryRepo.save(ale);
		ipa = categoryRepo.save(ipa);

		// Reviews
		Review elliotNess = new Review("Elliot Ness Amber Lager", "./elliot-ness.png",
				"Lorem ipsum dolor amet forage paleo humblebrag art party cred bespoke squid pok pok mlkshk iPhone tote bag PBR&B thundercats cloud bread hammock. Williamsburg forage direct trade, irony church-key hell of readymade roof party microdosing. Pabst meh vinyl locavore lo-fi pour-over, skateboard polaroid swag viral tousled pok pok. Franzen selvage fashion axe 3 wolf moon.",
				"6.1%", "Great Lakes", lager);
//		elliotNess = reviewRepo.save(elliotNess);
//		elliotNess.addTag(hoppy);
//		elliotNess.addTag(bold);
//		elliotNess.addTag(bitter);
//		elliotNess.addTag(fruity);
		elliotNess = reviewRepo.save(elliotNess);

		Review lightkeeper = new Review("Light Keeper Blonde Ale", "./lightkeeper.png",
				"Waistcoat brooklyn biodiesel flannel. Sartorial waistcoat cold-pressed fanny pack retro DIY VHS cornhole meh freegan. Hell of ramps heirloom, hashtag raw denim gluten-free vice wayfarers kogi. Readymade heirloom viral beard art party. Biodiesel beard drinking vinegar keytar photo booth retro artisan. Tofu wayfarers tacos narwhal yuccie whatever air plant. Woke franzen wolf cold-pressed chicharrones.",
				"6.6%", "Great Lakes", ale);
//		lightkeeper.addTag(rich);
//		lightkeeper.addTag(malty);
//		lightkeeper.addTag(caramel);
//		lightkeeper.addTag(citrus);
		lightkeeper = reviewRepo.save(lightkeeper);

		Review commodorePerry = new Review("Commodore Perry IPA", "./commodore-perry.png",
				"Try-hard vice chia hot chicken pabst hashtag mumblecore blog farm-to-table chambray irony listicle shoreditch. Banh mi YOLO irony pok pok drinking vinegar occupy pork belly enamel pin. Poke pinterest tbh chia, synth intelligentsia biodiesel stumptown XOXO vinyl sriracha. Tattooed gentrify occupy trust fund selfies godard pitchfork venmo everyday carry fanny pack vegan. Tilde meh banh mi single-origin coffee gochujang. 8-bit tumblr raw denim, fam +1 fingerstache selfies sartorial prism four loko bicycle rights dreamcatcher activated charcoal.",
				"7.7%", "Great Lakes", ipa);
//		commodorePerry.addTag(pine);
//		commodorePerry.addTag(crisp);
//		commodorePerry.addTag(fullBodied);
//		commodorePerry.addTag(wheat);
		commodorePerry = reviewRepo.save(commodorePerry);

	}

}
