package com.citicompass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "functional_requirements")
public class FunctionalRequirement {
    @Id
    private String id;
    private String repositoryId;
    private String title;
    private String description;
    private String fileUrl;
    private String createdBy;
    private LocalDateTime createdAt;
    private String status;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fr_id")
    private List<Comment> comments;
}
