package org.wecancodeit.reviewssitev3.models;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private Long id;
	private String tagName;
	@JsonIgnore
	@ManyToMany(mappedBy="tags")
	private Collection<Review> reviews;

	public Tag() {

	}

	public Tag(String tagName) {
		this.tagName = tagName;
	
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

	@Override
	public int hashCode() {
		return Objects.hash(id, reviews, tagName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		return Objects.equals(id, other.id) && Objects.equals(reviews, other.reviews)
				&& Objects.equals(tagName, other.tagName);
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagName=" + tagName + ", reviews=" + reviews + ", getId()=" + getId()
				+ ", getTagName()=" + getTagName() + ", getReviews()=" + getReviews() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	

}
