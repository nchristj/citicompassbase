package com.citicompass.controller;

import com.citicompass.model.Repository;
import com.citicompass.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/repositories")
public class RepositoryController {

    @Autowired
    private RepositoryService repositoryService;

    @GetMapping
    public List<Repository> getAllRepositories() {
        return repositoryService.getAllRepositories();
    }

    @GetMapping("/{id}")
    public Optional<Repository> getRepositoryById(@PathVariable String id) {
        return repositoryService.getRepositoryById(id);
    }

    @PostMapping
    public Repository createRepository(@RequestBody Repository repository) {
        return repositoryService.saveRepository(repository);
    }

    @DeleteMapping("/{id}")
    public void deleteRepository(@PathVariable String id) {
        repositoryService.deleteRepository(id);
    }
}
