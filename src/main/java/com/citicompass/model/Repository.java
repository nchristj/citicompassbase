package com.citicompass.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repositories")
public class Repository {
    @Id
    private String id;
    private String name;
    private String description;
    private String gitUrl;
    @ElementCollection
    private List<String> linkedDevelopers;
    @ElementCollection
    private List<String> linkedBAs;
    private LocalDateTime createdAt;
    private LocalDateTime lastAnalysis;
    private Integer totalAPIs;
    private Integer vulnerableModules;
}
