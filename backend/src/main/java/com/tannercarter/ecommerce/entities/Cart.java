package com.tannercarter.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "carts")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    @JsonIgnore
    private Long id;

    @JsonProperty("orderTrackingNumber")
    private String orderTrackingNumber;

    @Column(precision = 19, scale = 2)
    @JsonProperty("package_price")
    private BigDecimal packagePrice;

    @JsonProperty("party_size")
    private int partySize;

    @Enumerated(EnumType.STRING)
    @JsonProperty("status")
    private StatusType status;

    @CreatedDate
    @JsonProperty("create_date")
    private Date createDate;

    @LastModifiedDate
    @JsonProperty("last_update")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
}
