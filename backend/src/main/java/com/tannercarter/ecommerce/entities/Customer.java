package com.tannercarter.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customers")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    @JsonProperty("id")
    private Long id;

    @Column(name="customer_first_name")
    @JsonProperty("firstName")
    private String firstName;

    @Column(name="customer_last_name")
    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("postal_code")
    private String postalCode;

    @JsonProperty("phone")
    private String phone;

    @CreatedDate
    @JsonProperty("create_date")
    private LocalDateTime createDate;

    @LastModifiedDate
    @JsonProperty("last_update")
    private LocalDateTime lastUpdate;

    @ManyToOne
    @JoinColumn(name = "division_id")
    @JsonIgnore
    private Division division;
}



