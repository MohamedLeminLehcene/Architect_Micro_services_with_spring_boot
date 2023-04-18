package com.sdia.ArchitecturesMicroservices.mappers;

import com.sdia.ArchitecturesMicroservices.dto.CompteResponseDTO;
import com.sdia.ArchitecturesMicroservices.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {
    public CompteResponseDTO fromCompte(Compte compte)
    {
        CompteResponseDTO compteResponseDTO = new CompteResponseDTO();
        BeanUtils.copyProperties(compte,compteResponseDTO);
        return compteResponseDTO;
    }
}

