package org.wecancodeit.reviewssitev3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssitev3.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}
