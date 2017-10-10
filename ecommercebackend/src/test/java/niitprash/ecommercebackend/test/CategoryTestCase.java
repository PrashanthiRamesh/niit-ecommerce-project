package niitprash.ecommercebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niitprash.ecommercebackend.dao.CategoryDAO;
import niitprash.ecommercebackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("niitprash.ecommercebackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	// @Test
	// public void testAddCategory() {
	//
	// category = new Category();
	//
	// category.setName("Sports Wear");
	// category.setDescription(
	// "Sports wear is a category of men's and women's clothing which derives its
	// unique style from the clothes worn in the 19th-century American West");
	// category.setImageUrl("CAT_2.png");
	//
	// assertEquals("Successfully added a category inside the
	// table!",true,categoryDAO.add(category));
	//
	//
	// }

	// @Test
	// public void testGetCategory() {
	//
	// category = categoryDAO.get(1);
	//
	//
	// assertEquals("Success :) ","Western Wear",category.getName());
	//
	//
	// }

	// @Test
	// public void testUpdateCategory() {
	//
	// category = categoryDAO.get(1);
	//
	// category.setName("Western Clothes");
	//
	// assertEquals("Success :)",true,categoryDAO.update(category));
	//
	//
	// }
	//

	// @Test
	// public void testDeleteCategory() {
	//
	// category = categoryDAO.get(1);
	// assertEquals("Success :)",true,categoryDAO.delete(category));
	//
	//
	// }

	// @Test
	// public void testListCategory() {
	//
	// assertEquals("Success :)",1,categoryDAO.list().size());
	//
	//
	// }

	@Test
	public void testCRUDCategory() {

		// add operation
		category = new Category();

		category.setName("Casual Wear");
		category.setDescription(
				"Casual wear is a category of men's and women's clothing which derives its unique style from the clothes worn in the 19th-century American West");
		category.setImageUrl("CAT_1.png");

		assertEquals("Bug :(", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Ethnic Wear");
		category.setDescription("Ethnic wear is a category of men's and women's clothing which derives its unique style from the clothes worn in the 19th-century American West");
		category.setImageUrl("CAT_2.png");

		assertEquals("Bug :(", true, categoryDAO.add(category));

		// fetching and updating the category
		category = categoryDAO.get(2);

		category.setName("Traditional Wear");

		assertEquals("Update Bug :(", true, categoryDAO.update(category));

		// delete the category
		assertEquals("Delete Bug :(", true, categoryDAO.delete(category));

		// fetching the list
		assertEquals("List Bug :(", 1, categoryDAO.list().size());

	}

}