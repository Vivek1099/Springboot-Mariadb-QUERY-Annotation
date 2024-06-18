package com.example.Springboot_Mariadb_QUERY.Annotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerRepository extends JpaRepository<Customer,Integer>
{
	// using Query annotation 

	// JPQL 
	  @Query("from customer c where c.id=?1") // position based
	//@Query("from customer c where c.id=:id") // name based
	  Customer getById(int id);
	  
	  @Query("from customer c where c.fname=?1 and c.lname=?2")
	  Customer getByFirstnLastName(String fname,String lname);
	  
//	  @Query("from customer where c.cage>18")
//	  Customer getByAge();
}
