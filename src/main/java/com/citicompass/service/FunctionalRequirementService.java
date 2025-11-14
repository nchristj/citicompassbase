package com.citicompass.service;

import com.citicompass.model.FunctionalRequirement;
import com.citicompass.repository.FunctionalRequirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FunctionalRequirementService {

    @Autowired
    private FunctionalRequirementRepository functionalRequirementRepository;

    public List<FunctionalRequirement> getAllFunctionalRequirements() {
        return functionalRequirementRepository.findAll();
    }

    public Optional<FunctionalRequirement> getFunctionalRequirementById(String id) {
        return functionalRequirementRepository.findById(id);
    }

    public FunctionalRequirement saveFunctionalRequirement(FunctionalRequirement functionalRequirement) {
        return functionalRequirementRepository.save(functionalRequirement);
    }

    public void deleteFunctionalRequirement(String id) {
        functionalRequirementRepository.deleteById(id);
    }
}
