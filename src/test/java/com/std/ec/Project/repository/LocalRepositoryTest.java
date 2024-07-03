package com.std.ec.Project.repository;

import com.std.ec.Project.entity.Customer;
import com.std.ec.Project.entity.Local;
import com.std.ec.Project.entity.Manager;
import com.std.ec.Project.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocalRepositoryTest {
    @Autowired
    private  LocalRepository localRepository;

    @Test
    public void  saveLocal(){
        Manager manager = Manager.builder()
                .firstName("Juan")
                .lastName("Perez")
                .build();
        Local local = Local.builder()
                .name("PetShop")
                .floor("Second Floor")
                .manager(manager)
                .build();
        localRepository.save(local);
    }

    @Test   //fect tipe
    public  void findAllLocals(){
        List<Local> localList = localRepository.findAll();
        System.out.println("localList ="+localList);
    }

    @Test
    public void saveLocalWithOrders(){
        Manager manager = Manager.builder()
                .firstName("Juana")
                .lastName("rodriguez ")
                .build();

        Order order = Order.builder()
                .description("pedido de lasagna")
                .price(2.000)
                .build();

        Order order2 = Order.builder()
                .description("pedido de pizza")
                .price(2.900)
                .build();

        Local local = Local.builder()
                .name("Italiar Restaurant")
                .floor("Third Floor")
                .manager(manager)
                //.orderList(List.of(order,order2))
                .build();
        localRepository.save(local);
    }
    @Test
    public void  findAllLocalsWithOrders(){
        List<Local> localList = localRepository.findAll();
        System.out.println("localList =" + localList);


    }
    @Test
    public void saveLocalWithCustomer(){
        Customer customer = Customer.builder()
                .firstName("carl")
                .lastName("Jhonson")
                .email("carl@ejemplo.com")
                .build();
        Customer customer2 = Customer.builder()
                .firstName("Eddie")
                .lastName("Pulaski")
                .email("eddie@ejemplo.com")
                .build();



        Local local = Local.builder()
                .name("Clukin ' Bell")
                .floor("frist floor")
                .customerList(List.of(customer,customer2))
                .build();
        localRepository.save(local);


    }
    @Test
    public void findAllLocalsWithCustomers(){
        List<Local>localList = localRepository.findAll();
        System.out.println("localList =" +localList);
    }

    @Test
    public void findCustomersByLocal(){
        Local local = localRepository.findById(9L).get();
        List<Customer> customerList = local.getCustomerList();
        System.out.println("CustomerList = " +customerList);
    }

}