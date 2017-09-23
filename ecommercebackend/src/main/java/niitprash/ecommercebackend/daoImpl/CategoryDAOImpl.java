package niitprash.ecommercebackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import niitprash.ecommercebackend.dao.CategoryDAO;
import niitprash.ecommercebackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		Category category = new Category();
		category.setId(1);
		category.setName("Western Wear");
		category.setDescription(
				"Western wear is a category of men's and women's clothing which derives its unique style from the clothes worn in the 19th-century American West");
		category.setImageUrl("CAT_1.png");
		categories.add(category);

		category = new Category();
		category.setId(2);
		category.setName("Sports Wear");
		category.setDescription(
				"Sportswear is an American fashion term originally used to describe separates, but which, since the 1930s, has come to be applied to day and evening fashions of varying degrees of formality that demonstrate a specific relaxed approach to their design, while remaining appropriate for a wide range of social occasions");
		category.setImageUrl("CAT_2.png");
		categories.add(category);

		category = new Category();
		category.setId(3);
		category.setName("Casual Wear");
		category.setDescription(
				"In the European tradition, casual is the dress code that emphasizes comfort and personal expression over presentation, formality and conformity.");
		category.setImageUrl("CAT_3.png");
		categories.add(category);
	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub

		for (Category category : categories) {
			if (category.getId() == id)
				return category;

		}

		return null;
	}

}
