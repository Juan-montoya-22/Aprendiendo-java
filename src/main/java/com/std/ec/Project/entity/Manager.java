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

public class Manager {
    @Id
    @SequenceGenerator(
            name = "manager:sequence",
            sequenceName = "manager:sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "manager:sequence",
            strategy = GenerationType.SEQUENCE
    )
    private  long managerId;
    private String firstName;
    private String lastName;


    @OneToOne(
            mappedBy = "manager",
            fetch = FetchType.EAGER
    )
    private  Local local;
}
