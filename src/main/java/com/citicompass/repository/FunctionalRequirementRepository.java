package com.citicompass.repository;

import com.citicompass.model.FunctionalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunctionalRequirementRepository extends JpaRepository<FunctionalRequirement, String> {
}
