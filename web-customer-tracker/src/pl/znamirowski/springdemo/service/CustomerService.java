package pl.znamirowski.springdemo.service;

import java.util.List;

import pl.znamirowski.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
