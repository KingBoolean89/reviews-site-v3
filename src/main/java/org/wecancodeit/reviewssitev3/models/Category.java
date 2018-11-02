package org.wecancodeit.reviewssitev3.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private Long id;
	private String categoryName;
	@OneToMany(mappedBy = "category")
	private Collection<Review> reviews;

	public Category() {

	}

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public Long getId() {
		return id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public Collection<Review> getReviews() {
		return reviews;
	}

}
