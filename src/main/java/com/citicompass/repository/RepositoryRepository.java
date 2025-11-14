package com.citicompass.repository;

import com.citicompass.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryRepository extends JpaRepository<Repository, String> {
}
