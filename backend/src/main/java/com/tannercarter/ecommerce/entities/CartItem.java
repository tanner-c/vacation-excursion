package com.tannercarter.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    @JsonProperty("id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id")
    @JsonProperty("vacation")
    private Vacation vacation;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "excursion_cartitem",
        joinColumns = @JoinColumn(name = "cart_item_id"),
        inverseJoinColumns = @JoinColumn(name = "excursion_id"))
    @JsonIgnore
    private Set<Excursion> excursions;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    @JsonProperty("cart")
    private Cart cart;

    @CreatedDate
    @JsonProperty("create_date")
    private Date createDate;

    @LastModifiedDate
    @JsonProperty("last_update")
    private Date lastUpdate;
}
