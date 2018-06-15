package com.sydney.sample.dynamic.datasource.customer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sydney.sample.dynamic.datasource.customer.entity.Customer;

@Repository
public interface CustomerDao {
	public void insert(Customer customer);
	
	List<Customer> findList(Customer customer);
}
