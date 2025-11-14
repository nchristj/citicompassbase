package com.citicompass.service;

import com.citicompass.model.Repository;
import com.citicompass.repository.RepositoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepositoryService {

    @Autowired
    private RepositoryRepository repositoryRepository;

    public List<Repository> getAllRepositories() {
        return repositoryRepository.findAll();
    }

    public Optional<Repository> getRepositoryById(String id) {
        return repositoryRepository.findById(id);
    }

    public Repository saveRepository(Repository repository) {
        return repositoryRepository.save(repository);
    }

    public void deleteRepository(String id) {
        repositoryRepository.deleteById(id);
    }
}
