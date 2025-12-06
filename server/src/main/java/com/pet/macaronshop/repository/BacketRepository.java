package com.pet.macaronshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pet.macaronshop.model.Backet;

@Repository
public interface BacketRepository extends JpaRepository<Backet, Long> {
}
