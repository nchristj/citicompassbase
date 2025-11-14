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
@Table(name = "impact_analyses")
public class ImpactAnalysis {
    @Id
    private String id;
    private String frId;
    private String repositoryId;
    private LocalDateTime analyzedAt;
    private Integer totalImpactedAPIs;
    private Integer affectedModules;
    private String criticalityLevel;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "analysis_id")
    private List<ImpactedAPI> impactedAPIs;
}
