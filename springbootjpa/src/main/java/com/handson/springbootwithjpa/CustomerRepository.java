package com.handson.springbootwithjpa;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	/*
	 * Caused by: java.lang.IllegalArgumentException: Failed to create query for
	 * method public abstract java.util.List
	 * com.handson.springbootwithjpa.CustomerRepository.findByCode(int)! No property
	 * code found for type Customer!
	 * 
	 * List<Customer> findByCode(int code);
	 * 
	 */

	List<Customer> findByZipCode(int code);

	/*
	 * @Query
	 */
	@Query(value = "select * from customer where zip_code=:code", nativeQuery = true)
	Customer findByNativeQueryCode(@Param("code") int code);

	/*
	 * @NamedQuery
	 */
	Customer namedQueryBySearchStr(@Param("name") String name);

	// Sorting
	List<Customer> findAll(Sort sort);

	// Pagination
	@Query(value = "select * from customer", nativeQuery = true)
	Page<Customer> findUsersWithPagination(Pageable pageable);

}
