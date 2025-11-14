package com.citicompass.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dependency_nodes")
public class DependencyNode {
    @Id
    private String id;
    private String name;
    private String type;
    private String description;
    private boolean vulnerable;
    @ElementCollection
    private List<String> dependencies;
}
