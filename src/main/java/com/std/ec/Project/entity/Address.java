package com.std.ec.Project.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
@AttributeOverrides({
        @AttributeOverride(
                name ="city",
                column = @Column(name="customer_city")
        ),
        @AttributeOverride(
                name ="mainStreet",
                column = @Column(name="customer_main_Street")
        ),
        @AttributeOverride(
                name ="secondaryStreet",
                column = @Column(name="customer_secondary_Street")
        )

})
public class Address {
    private String city;
    private String mainStreet;
    private String secondaryStreet;
}
