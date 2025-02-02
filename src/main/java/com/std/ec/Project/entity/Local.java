package com.std.ec.Project.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "manager")

public class Local {
    @Id
    @SequenceGenerator(
            name ="local_sequence",
            sequenceName = "local_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "local_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private  long localId;
    private String name;
    private String floor;

    @OneToOne(
            cascade = CascadeType.PERSIST,
            //operaciones en cascada (afecta a clase hija)
            fetch=FetchType.EAGER // tipo de busqueda (Lazy o Eager)
           // optional = false
    )
    @JoinColumn(
            name = "manager_id",
            referencedColumnName = "managerId"
    )
    private Manager manager;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "local_customer_map",
            joinColumns = @JoinColumn(
                    name = "local_id",
                    referencedColumnName = "localId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "customer_id",
                    referencedColumnName = "customerId"
            )
    )

    private  List<Customer> customerList;

 /*   @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER

    )

    @JoinColumn(
            name = "local_id",
            referencedColumnName = "localId"
    )
    private List<Order> orderList;*/


}
