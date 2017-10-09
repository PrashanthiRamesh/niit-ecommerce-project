package niitprash.ecommercebackend.dao;

import java.util.List;

import niitprash.ecommercebackend.dto.Category;

public interface CategoryDAO {
	
	//get single category based on id
    Category get(int id);
	
	//get all categories
	List<Category> list();
	
	//adding a new category
    boolean add(Category category);
    
  //updating a category
    boolean update(Category category);
    
  //deleting a category
    boolean delete(Category category);
	

	
	
}
