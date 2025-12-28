package com.tannercarter.ecommerce.dao;

import com.tannercarter.ecommerce.entities.Excursion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExcursionRepository extends JpaRepository<Excursion, Long> {
}
