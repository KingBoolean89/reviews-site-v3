package org.wecancodeit.reviewssitev3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.wecancodeit.reviewssitev3.models.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
