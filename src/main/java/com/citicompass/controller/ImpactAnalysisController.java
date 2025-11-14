package com.citicompass.controller;

import com.citicompass.model.ImpactAnalysis;
import com.citicompass.service.ImpactAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/impact-analyses")
public class ImpactAnalysisController {

    @Autowired
    private ImpactAnalysisService impactAnalysisService;

    @GetMapping
    public List<ImpactAnalysis> getAllImpactAnalyses() {
        return impactAnalysisService.getAllImpactAnalyses();
    }

    @GetMapping("/{id}")
    public Optional<ImpactAnalysis> getImpactAnalysisById(@PathVariable String id) {
        return impactAnalysisService.getImpactAnalysisById(id);
    }

    @PostMapping
    public ImpactAnalysis createImpactAnalysis(@RequestBody ImpactAnalysis impactAnalysis) {
        return impactAnalysisService.saveImpactAnalysis(impactAnalysis);
    }

    @DeleteMapping("/{id}")
    public void deleteImpactAnalysis(@PathVariable String id) {
        impactAnalysisService.deleteImpactAnalysis(id);
    }
}
