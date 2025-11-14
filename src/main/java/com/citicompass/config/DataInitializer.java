package com.citicompass.config;

import com.citicompass.model.*;
import com.citicompass.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RepositoryRepository repositoryRepository;

    @Autowired
    private FunctionalRequirementRepository functionalRequirementRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ImpactAnalysisRepository impactAnalysisRepository;

    @Autowired
    private ImpactedAPIRepository impactedAPIRepository;

    @Autowired
    private CallStackItemRepository callStackItemRepository;

    @Autowired
    private DependencyNodeRepository dependencyNodeRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("u1", "John Doe", "john.doe@example.com", "password", "user");
        userRepository.save(user1);

        Repository repo1 = new Repository("r1", "CitiCompass", "A tool for navigating the Citi ecosystem.", "github.com/citi/compass", new ArrayList<>(), new ArrayList<>(), LocalDateTime.now(), LocalDateTime.now(), 0, 0);
        repositoryRepository.save(repo1);

        FunctionalRequirement fr1 = new FunctionalRequirement("fr1", "r1", "As a user, I want to see a list of all repositories.", "description", "file/url", "u1", LocalDateTime.now(), "open", new ArrayList<>());
        functionalRequirementRepository.save(fr1);

        Comment comment1 = new Comment("c1", "u1", "John Doe", "user", "This is a great idea!", LocalDateTime.now());
        commentRepository.save(comment1);

        ImpactAnalysis ia1 = new ImpactAnalysis("ia1", "fr1", "r1", LocalDateTime.now(), 1, 1, "High", new ArrayList<>());
        impactAnalysisRepository.save(ia1);

        ImpactedAPI api1 = new ImpactedAPI("api1", "GET /api/repositories", "Provides a list of all repositories.", new ArrayList<>(), "High");
        impactedAPIRepository.save(api1);

        CallStackItem csi1 = new CallStackItem("com.citicompass.service.RepositoryService.getAllRepositories", "description", 1);
        callStackItemRepository.save(csi1);

        DependencyNode dn1 = new DependencyNode("dn1", "com.citicompass.repository.RepositoryRepository", "dependency", "A dependency", false, new ArrayList<>());
        dependencyNodeRepository.save(dn1);
    }
}
