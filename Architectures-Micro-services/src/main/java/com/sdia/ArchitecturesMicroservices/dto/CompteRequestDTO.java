package com.sdia.ArchitecturesMicroservices.dto;

import com.sdia.ArchitecturesMicroservices.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteRequestDTO {
    private Date dateCreation;
    private Double solde;
    private TypeCompte type;
}
