package com.sdia.ArchitecturesMicroservices.dto;

import com.sdia.ArchitecturesMicroservices.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class CompteResponseDTO {
    private Long id;
    private Double solde;
    private Date dateCreation;
    private TypeCompte type;
}
