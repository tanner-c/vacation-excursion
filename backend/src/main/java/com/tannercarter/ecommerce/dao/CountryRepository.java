package com.tannercarter.ecommerce.dao;

import com.tannercarter.ecommerce.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
