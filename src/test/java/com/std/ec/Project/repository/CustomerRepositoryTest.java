package com.std.ec.Project.repository;

import com.std.ec.Project.entity.Address;
import com.std.ec.Project.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.SocketOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepository;

    //registrar los datos a tabla
    @Test
    public void saveCustomer(){
        Customer customer = Customer.builder()
                .firstName("Jose")
                .lastName("felipe")
                .email("joce@uan.edo")
                .build();
        customerRepository.save(customer);
    }

    @Test
    public void saveCustomerWithAddressEmbedded(){

        Address address = Address.builder()
                .mainStreet("NQS")
                .secondaryStreet("Av.64")
                .city("Bogota").build();
        Customer customer = Customer.builder()
                .firstName("Jose")
                .lastName("felipe")
                .email("joce@uan.edo")
                .address(address)
                .build();
        customerRepository.save(customer);

    }



    // para filtar el nombre
    @Test
    public void findCustomerByFirstName(){
        Customer customer = customerRepository.findByFirstName("Jose").get();
        System.out.println("Customer = "+customer);
    }
// para llamar todos los registros
    @Test
    public void findAllCustomers(){
        List<Customer> customerList = customerRepository.findAll();
        System.out.println("Customer = "+customerList);
    }

    @Test
    public void findAllCustomersFirstNameContainig(){
        List<Customer> customerList = customerRepository.findByFirstNameContaining("Al");
        System.out.println("customerList = "+customerList);
    }

    @Test
    public void findAllCustomersLastNameNotNull(){
        List<Customer> customerList = customerRepository.findByLastNameNotNull();
        System.out.println("customerList = "+customerList);
    }

    @Test
    public void findAllCustomersByAddresscity(){
        List<Customer> customerList = customerRepository.findByAddress_City("bogota");
        System.out.println("customerList = "+customerList);
    }

    @Test
    public void getCustomerByEmailAddress(){
        Customer customer = customerRepository.getCustomerByEmailAddress("joce@uan.edo");
        System.out.println("customer = "+ customer);
    }

    @Test
    public void getCustomerFristNameByEmailAddress(){
        String firstName = customerRepository.getCustomerFristNameByEmailAddress("joce@uan.edo");
        System.out.println("customer = "+ firstName);
    }

    @Test
    public void getCustomerByEmailAddressNative(){
        Customer customer = customerRepository.getCustomerByEmailAddressNativa("joce@uan.edo");
        System.out.println("customer = "+ customer);
    }

    @Test
    public void getCustomerByEmailAddressNativeNamedParam(){
        Customer customer = customerRepository.getCustomerByEmailAddressNativaNamedParam("joce@uan.edo");
        System.out.println("customer = "+ customer);
    }

    @Test
    public void updateCustomerNameByEmail(){
        customerRepository.updateCustomerNameByEmail("lucas","joce@uan.edo");
    }

}