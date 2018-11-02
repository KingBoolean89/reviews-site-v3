package org.wecancodeit.reviewssitev3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long id;
	private String commentName;
	private String commentContent;
	@ManyToOne
	private Review review;

	public Comment() {

	}

	public Comment(Long id, String commentName, String commentContent) {
		super();
		this.id = id;
		this.commentName = commentName;
		this.commentContent = commentContent;
	}

	public Long getId() {
		return id;
	}

	public String getCommentName() {
		return commentName;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public Review getReview() {
		return review;
	}

}
