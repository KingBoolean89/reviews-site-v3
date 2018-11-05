package org.wecancodeit.reviewssitev3.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
	@Id
	@GeneratedValue
	private Long id;
	private String commentName;
	private String commentContent;
	@JsonIgnore
	@ManyToOne
	private Review review;

	public Comment() {

	}

	public Comment(String commentName, String commentContent, Review review) {
		this.commentName = commentName;
		this.commentContent = commentContent;
		this.review = review;
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
