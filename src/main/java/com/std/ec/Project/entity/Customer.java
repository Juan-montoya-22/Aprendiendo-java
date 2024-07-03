package com.std.ec.Project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name ="tbl_customer",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email_address"
        )
)
public class Customer {

    @Id
    @SequenceGenerator(
            name = "custumer_sequence",
            sequenceName = "custumer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "custumer_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private long customerid;
    private String firstName;
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String email;
    //private String customercity;
    //private String customermainStreet;
    //private String customerSecondaryStreet;
    @Embedded
    private Address address;

}
