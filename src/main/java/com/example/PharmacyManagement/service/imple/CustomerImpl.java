package com.example.PharmacyManagement.service.imple;

import com.example.PharmacyManagement.dao.CustomerDao;
import com.example.PharmacyManagement.entity.Customer;
import com.example.PharmacyManagement.exception.ApiException;
import com.example.PharmacyManagement.repository.CustomerRespository;
import com.example.PharmacyManagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerImpl implements CustomerService {
    private CustomerRespository customerRespository;
    @Autowired
    public CustomerImpl(CustomerRespository customerRespository) {
        this.customerRespository = customerRespository;
    }

    @Override
    public Customer addCustomer(Customer customer){
        Customer customers=customerRespository.findBycustomerPhone(customer.getCustomerPhone());
        if(customers==null){
            customerRespository.save(customer);
            return customer;
        }else{
            throw new ApiException("Customer ID already found ", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Customer> findAllCustomer(){
        return customerRespository.findAll();
    }

    @Override
    public List<Customer> listCustomer() {
        return customerRespository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRespository.save(customer);
    }
}
