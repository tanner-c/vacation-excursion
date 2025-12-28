package com.tannercarter.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "vacations")
@Getter
@Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    @JsonProperty("id")
    private Long id;

    @JsonProperty("vacation_title")
    private String vacationTitle;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image_URL")
    private String imageUrl;

    @Column(name="travel_fare_price", precision = 19, scale = 2)
    @JsonProperty("travel_price")
    private BigDecimal travelPrice;

    @OneToMany(mappedBy = "vacation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonProperty("excursions")
    private Set<Excursion> excursions;

    @CreatedDate
    @JsonProperty("create_date")
    private Date createDate;

    @LastModifiedDate
    @JsonProperty("last_update")
    private Date lastUpdate;


}
