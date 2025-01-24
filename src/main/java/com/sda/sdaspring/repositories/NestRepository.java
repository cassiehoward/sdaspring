package com.sda.sdaspring.repositories;

import com.sda.sdaspring.models.Nest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestRepository extends JpaRepository<Nest, Long> {
}
