package com.citicompass.repository;

import com.citicompass.model.DependencyNode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependencyNodeRepository extends JpaRepository<DependencyNode, String> {
}
