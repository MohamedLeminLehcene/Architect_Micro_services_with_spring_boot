package com.sdia.ArchitecturesMicroservices.web;

import com.sdia.ArchitecturesMicroservices.dto.CompteRequestDTO;
import com.sdia.ArchitecturesMicroservices.dto.CompteResponseDTO;
import com.sdia.ArchitecturesMicroservices.entities.Client;
import com.sdia.ArchitecturesMicroservices.entities.Compte;
import com.sdia.ArchitecturesMicroservices.enums.TypeCompte;
import com.sdia.ArchitecturesMicroservices.repositories.ClientRepository;
import com.sdia.ArchitecturesMicroservices.repositories.CompteRepository;
import com.sdia.ArchitecturesMicroservices.service.CompteService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class CompteServiceGraphQLController {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private CompteService compteService;
    @Autowired
    private ClientRepository clientRepository;

    @QueryMapping
    public List<Compte> comptesList(){
     return compteRepository.findAll();
    }

    @QueryMapping
    public Compte compteById(@Argument Long id)
    {
        return compteRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Compte %s not found",id)));
    }

    @MutationMapping
    public CompteResponseDTO addCompte(@Argument CompteRequestDTO compteServiceDTO)
    {
        return compteService.addCompte(compteServiceDTO);
    }

    @MutationMapping
    public CompteResponseDTO updateCompte(@Argument Long id,@Argument CompteRequestDTO compteServiceDTO)
    {
        System.out.println(compteServiceDTO.getSolde());
        return compteService.updateCompte(compteServiceDTO,id);
    }

    @MutationMapping
    public Boolean deleteCompte(@Argument Long id){
         compteRepository.deleteById(id);
         return true;
    }

    @QueryMapping
    public List<Client> clientList()
    {
        return clientRepository.findAll();
    }

}

