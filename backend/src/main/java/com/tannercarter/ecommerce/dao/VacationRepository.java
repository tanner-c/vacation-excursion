package com.tannercarter.ecommerce.dao;

import com.tannercarter.ecommerce.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
