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
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "divisions")
@Getter
@Setter
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    @JsonProperty("id")
    private Long id;

    @JsonProperty("division_name")
    private String division;

    @CreatedDate
    @JsonIgnore
    private LocalDateTime createDate;

    @Column(name="country_id")
    @JsonProperty("country_id")
    private Long countryId;

    @LastModifiedDate
    @JsonIgnore
    private LocalDateTime lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", insertable = false, updatable = false)
    @JsonIgnore
    private Country country;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Customer> customers;
}
