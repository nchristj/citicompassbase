package com.citicompass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "impacted_apis")
public class ImpactedAPI {
    @Id
    private String id;
    private String name;
    private String module;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "api_id")
    private List<CallStackItem> callStack;
    private String criticality;
}
