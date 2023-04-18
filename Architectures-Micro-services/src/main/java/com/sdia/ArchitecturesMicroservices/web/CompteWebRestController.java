package com.sdia.ArchitecturesMicroservices.web;

import com.sdia.ArchitecturesMicroservices.dto.CompteRequestDTO;
import com.sdia.ArchitecturesMicroservices.dto.CompteResponseDTO;
import com.sdia.ArchitecturesMicroservices.entities.Client;
import com.sdia.ArchitecturesMicroservices.entities.Compte;
import com.sdia.ArchitecturesMicroservices.mappers.CompteMapper;
import com.sdia.ArchitecturesMicroservices.repositories.ClientRepository;
import com.sdia.ArchitecturesMicroservices.repositories.CompteRepository;
import com.sdia.ArchitecturesMicroservices.service.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
/* Web Service RestFull permet de gérér des comptes */

@RestController
@RequestMapping("/api")
public class CompteWebRestController {
    private CompteRepository compteRepository;

    private ClientRepository clientRepository;
    private CompteService compteService;


    private CompteMapper compteMapper;

    public CompteWebRestController(CompteRepository compteRepository,CompteService compteService,CompteMapper compteMapper,ClientRepository clientRepository)
    {
        this.compteRepository=compteRepository;
        this.compteService=compteService;
        this.compteMapper=compteMapper;
        this.clientRepository=clientRepository;
    }

    @GetMapping("/comptes")
    public List<Compte> compteList()
    {
        return compteRepository.findAll();
    }

    @GetMapping("/Clients")
    public List<Client> clientList(){return clientRepository.findAll();}

    @GetMapping("/comptes/{id}")
    public Compte compteById(@PathVariable Long id)
    {
        return compteRepository.findById(id).orElseThrow(()->new RuntimeException("No found this Id : "+id));
    }

    @PostMapping("/comptes/saveCompte")
    public CompteResponseDTO addCompte(@RequestBody CompteRequestDTO requestDTO)
    {
        return compteService.addCompte(requestDTO);
    }

    @PutMapping("/comptes/updateCompte/{id}")
    public Compte updateCompte(@RequestBody Compte compte,@PathVariable Long id)
    {
        Compte c = compteRepository.findById(id).orElseThrow(()->new RuntimeException("No found this Id : "+id));

       if(compte.getSolde()!=null) c.setSolde(compte.getSolde());
       if(compte.getDateCreation()!=null) c.setDateCreation(compte.getDateCreation());
       if(compte.getType()!=null) c.setType(compte.getType());

       return compteRepository.save(c);
    }

    @DeleteMapping("/comptes/delete/{id}")
    public void deleteCompte(@PathVariable Long id)
    {
        compteRepository.deleteById(id);
    }



}
