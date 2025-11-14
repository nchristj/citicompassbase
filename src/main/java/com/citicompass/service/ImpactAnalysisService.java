package com.citicompass.service;

import com.citicompass.model.ImpactAnalysis;
import com.citicompass.repository.ImpactAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpactAnalysisService {

    @Autowired
    private ImpactAnalysisRepository impactAnalysisRepository;

    public List<ImpactAnalysis> getAllImpactAnalyses() {
        return impactAnalysisRepository.findAll();
    }

    public Optional<ImpactAnalysis> getImpactAnalysisById(String id) {
        return impactAnalysisRepository.findById(id);
    }

    public ImpactAnalysis saveImpactAnalysis(ImpactAnalysis impactAnalysis) {
        return impactAnalysisRepository.save(impactAnalysis);
    }

    public void deleteImpactAnalysis(String id) {
        impactAnalysisRepository.deleteById(id);
    }
}
