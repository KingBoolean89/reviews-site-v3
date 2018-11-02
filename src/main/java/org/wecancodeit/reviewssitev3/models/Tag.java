package org.wecancodeit.reviewssitev3.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	private String tagName;
	@ManyToMany
	private Collection<Review> reviews;

	public Tag() {

	}

	public Tag(String tagName, Collection<Review> reviews) {
		this.tagName = tagName;
		this.reviews = reviews;
	}

	public Long getId() {
		return id;
	}

	public String getTagName() {
		return tagName;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

}
