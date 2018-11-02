package org.wecancodeit.reviewssitev3.repositories;

import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.reviewssitev3.models.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Resource
	CategoryRepository categoryRepo;
	@Resource
	CommentRepository commentRepo;
	@Resource
	ReviewRepository reviewRepo;
	@Resource
	TagRepository tagRepo;

	@Test
	public void shouldReturnAllCategories() {
		// Arrange
		Category category = categoryRepo.save(new Category(""));
		Category category2 = categoryRepo.save(new Category("a"));
		// Act
		Iterable<Category> result = categoryRepo.findAll();
		// Assert
		assertThat(result, hasItems(category, category2));
	}

	@Test
	public void shouldReturnOneCategory() {
		// Arrange
		Category category = categoryRepo.save(new Category(""));
		Category category2 = categoryRepo.save(new Category("a"));
		// Act
		Category result = categoryRepo.findById(category.getId()).get();
		// Assert
		assertThat(result, is(category));
	}

	@Test
	public void shouldReturnOtherCategory() {
		// Arrange
		Category category = categoryRepo.save(new Category(""));
		Category category2 = categoryRepo.save(new Category("a"));
		// Act
		Category result = categoryRepo.findById(category2.getId()).get();
		// Assert
		assertThat(result, is(category2));
	}

}
