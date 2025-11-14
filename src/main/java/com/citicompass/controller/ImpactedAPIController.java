package com.citicompass.controller;

import com.citicompass.model.ImpactedAPI;
import com.citicompass.service.ImpactedAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/impacted-apis")
public class ImpactedAPIController {

    @Autowired
    private ImpactedAPIService impactedAPIService;

    @GetMapping
    public List<ImpactedAPI> getAllImpactedAPIs() {
        return impactedAPIService.getAllImpactedAPIs();
    }

    @GetMapping("/{id}")
    public Optional<ImpactedAPI> getImpactedAPIById(@PathVariable String id) {
        return impactedAPIService.getImpactedAPIById(id);
    }

    @PostMapping
    public ImpactedAPI createImpactedAPI(@RequestBody ImpactedAPI impactedAPI) {
        return impactedAPIService.saveImpactedAPI(impactedAPI);
    }

    @DeleteMapping("/{id}")
    public void deleteImpactedAPI(@PathVariable String id) {
        impactedAPIService.deleteImpactedAPI(id);
    }
}
