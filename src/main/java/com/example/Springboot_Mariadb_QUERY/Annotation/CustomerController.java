package com.example.Springboot_Mariadb_QUERY.Annotation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController 
{
	@Autowired
	CustomerRepository crepo;
	
	@RequestMapping("/test")
	public String test()
	{
		return "this is query test";
	}
	
	@PostMapping("/save")
	public String saveall(@RequestBody Customer customer)
	{
		crepo.save(customer);
		return "Data saved to customer";
	}

	@GetMapping("/show")
	List<Customer> showall()
	{
		return crepo.findAll();
	}

	@RequestMapping("/id/{id}")
	public Optional<Customer> ById(@PathVariable int id)
	{
		return crepo.findById(id);
	}
	
	@GetMapping("/byid/{id}")
	public Customer getById(@PathVariable int id)
	{
		return crepo.getById(id);
	}

	@GetMapping("/byfirstnlast/{fname}/{lname}")
	public Customer getById(@PathVariable String fname,@PathVariable String lname)
	{
		return crepo.getByFirstnLastName(fname, lname);
	}
	
//	@GetMapping("/byage")
//	public Customer Byage()
//	{
//		return crepo.getByAge();
//	}
}
