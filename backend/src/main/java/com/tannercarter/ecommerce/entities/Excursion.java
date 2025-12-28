package com.tannercarter.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "excursions")
@Getter
@Setter
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "excursion_id")
    @JsonProperty("id")
    private Long id;

    @JsonProperty("excursion_title")
    private String excursionTitle;

    @Column(precision = 19, scale = 2)
    @JsonProperty("excursion_price")
    private BigDecimal excursionPrice;

    @JsonProperty("image_URL")
    private String imageUrl;

    @CreatedDate
    @JsonProperty("create_date")
    private Date createDate;

    @LastModifiedDate
    @JsonProperty("last_update")
    private Date lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id")
    @JsonIgnore
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<CartItem> cartItems;
}
