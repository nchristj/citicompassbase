package com.citicompass.service;

import com.citicompass.model.ImpactedAPI;
import com.citicompass.repository.ImpactedAPIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpactedAPIService {

    @Autowired
    private ImpactedAPIRepository impactedAPIRepository;

    public List<ImpactedAPI> getAllImpactedAPIs() {
        return impactedAPIRepository.findAll();
    }

    public Optional<ImpactedAPI> getImpactedAPIById(String id) {
        return impactedAPIRepository.findById(id);
    }

    public ImpactedAPI saveImpactedAPI(ImpactedAPI impactedAPI) {
        return impactedAPIRepository.save(impactedAPI);
    }

    public void deleteImpactedAPI(String id) {
        impactedAPIRepository.deleteById(id);
    }
}
