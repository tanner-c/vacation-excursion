package com.tannercarter.ecommerce.dao;

import com.tannercarter.ecommerce.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division, Long> {
}
