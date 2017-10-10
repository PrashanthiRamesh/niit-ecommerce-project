package niitprash.ecommercebackend.dao;

import java.util.List;

import niitprash.ecommercebackend.dto.Supplier;

public interface SupplierDAO {
	
	Supplier get(int supplierId);

	List<Supplier> list();

	boolean add(Supplier supplier);

	boolean update(Supplier supplier);

	boolean delete(Supplier supplier);
}
