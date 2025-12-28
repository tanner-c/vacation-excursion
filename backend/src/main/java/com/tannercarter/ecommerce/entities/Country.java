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
@Table(name = "countries")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    @JsonProperty("id")
    private Long id;

    @JsonProperty("country_name")
    private String country;

    @CreatedDate
    @JsonIgnore
    private Date createDate;

    @LastModifiedDate
    @JsonIgnore
    private Date lastUpdate;

    @OneToMany(mappedBy = "countryId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Division> divisions;
}
