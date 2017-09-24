package niitprash.ecommercebackend.dao;

import java.util.List;

import niitprash.ecommercebackend.dto.Category;

public interface CategoryDAO {
	
	boolean add(Category category);
	
	//get all categories
	List<Category> list();
	
	//get single category based on id
    Category get(int id);
}
