package org.wecancodeit.reviewssitev3.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssitev3.models.Category;
import org.wecancodeit.reviewssitev3.models.Review;
import org.wecancodeit.reviewssitev3.models.Tag;

public interface ReviewRepository extends CrudRepository<Review, Long> {
	Collection<Review>findByCategory(Category category);
	Collection<Review>findByTags(Tag tag);
	
	
	

}
