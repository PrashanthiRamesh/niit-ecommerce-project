package niitprash.ecommercebackend.test;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import niitprash.ecommercebackend.dao.SupplierDAO;
import niitprash.ecommercebackend.dto.Product;
import niitprash.ecommercebackend.dto.Supplier;

public class SupplierTestCase {
	private static AnnotationConfigApplicationContext context;

	private static SupplierDAO supplierDAO;

	private Supplier supplier;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("niitprash.ecommercebackend");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}

	@Test
	public void testCRUDSupplier() {

		// create operation
		supplier = new Supplier();

		supplier.setName("eFashion");
		supplier.setAddress("13B West Coast Mayflower");
		supplier.setCity("Mumbai");
		supplier.setRegion("Maharastra");
		supplier.setPostalCode(652364);
		supplier.setCountry("India");
		supplier.setPhone(4569325);
		supplier.setActive(true);
		
		assertEquals("Bug :(", true, supplierDAO.add(supplier));

		// reading and updating the supplier
		supplier = supplierDAO.get(1);
		supplier.setName("Vogue Apparel");
		assertEquals("Bug :(", true, supplierDAO.update(supplier));

		// delete
		assertEquals("Bug :(", true, supplierDAO.delete(supplier));

		// list
		assertEquals("Bug :(", 4, supplierDAO.list().size());

	}

}
