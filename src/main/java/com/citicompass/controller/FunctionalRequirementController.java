package com.citicompass.controller;

import com.citicompass.model.FunctionalRequirement;
import com.citicompass.service.FunctionalRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/functional-requirements")
public class FunctionalRequirementController {

    @Autowired
    private FunctionalRequirementService functionalRequirementService;

    @GetMapping
    public List<FunctionalRequirement> getAllFunctionalRequirements() {
        return functionalRequirementService.getAllFunctionalRequirements();
    }

    @GetMapping("/{id}")
    public Optional<FunctionalRequirement> getFunctionalRequirementById(@PathVariable String id) {
        return functionalRequirementService.getFunctionalRequirementById(id);
    }

    @PostMapping
    public FunctionalRequirement createFunctionalRequirement(@RequestBody FunctionalRequirement functionalRequirement) {
        return functionalRequirementService.saveFunctionalRequirement(functionalRequirement);
    }

    @DeleteMapping("/{id}")
    public void deleteFunctionalRequirement(@PathVariable String id) {
        functionalRequirementService.deleteFunctionalRequirement(id);
    }
}
