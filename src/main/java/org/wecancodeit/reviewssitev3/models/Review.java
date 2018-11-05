package org.wecancodeit.reviewssitev3.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String imageUrl;
	@Lob
	private String content;
	private String abv;
	private String brewery;
	@ManyToOne
	private Category category;
	@OneToMany(mappedBy = "review")
	private Collection<Comment> comments;
	@JsonIgnore
	@ManyToMany
	private Collection<Tag> tags;

	public Review() {

	}

	public Review(String title, String imageUrl, String content, String abv, String brewery, Category category,
			Tag... tags) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.content = content;
		this.abv = abv;
		this.brewery = brewery;
		this.category = category;
		this.tags = new HashSet<>(Arrays.asList(tags));
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getContent() {
		return content;
	}

	public Collection<Comment> getComments() {
		return comments;
	}

	public String getAbv() {
		return abv;
	}

	public String getBrewery() {
		return brewery;
	}

	public Category getCategory() {
		return category;
	}

	public Collection<Tag> getTags() {
		return tags;
	}
	public void addTag(Tag tag) {
		this.tags.add(tag);
	}
	public void removeTag(Tag tag) {
		this.tags.remove(tag);
	}
	

}
