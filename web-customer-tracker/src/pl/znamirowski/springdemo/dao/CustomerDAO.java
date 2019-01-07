package pl.znamirowski.springdemo.dao;

import java.util.List;

import pl.znamirowski.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
}
