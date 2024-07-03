package com.std.ec.Project.repository;

import com.std.ec.Project.entity.Local;
import com.std.ec.Project.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void saveOrder(){
        Local local = Local.builder()
                .name("Binco")
                .floor("Fourth Floor")
                .build();

        Order order = Order.builder()
                .description("camisa de tirantes blanca")
                .price(10.000)
                .local(local)
                .build();
        orderRepository.save(order);
    }

    @Test
    public void findAllOrdersPaging(){
        PageRequest firstPageWithThreeRecords = PageRequest.of(0,3);

        List<Order> orderList = orderRepository.findAll(firstPageWithThreeRecords).getContent();
        long totalElements = orderRepository.findAll(firstPageWithThreeRecords).getTotalElements();
        long totalPages = orderRepository.findAll(firstPageWithThreeRecords).getTotalPages();
        System.out.println("orderList" +orderList);
        System.out.println("TotalElements" + totalElements);
        System.out.println("totalPages" + totalPages);



    }
}