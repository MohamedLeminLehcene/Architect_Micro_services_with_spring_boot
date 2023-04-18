package com.sdia.ArchitecturesMicroservices.repositories;

import com.sdia.ArchitecturesMicroservices.entities.Client;
import com.sdia.ArchitecturesMicroservices.entities.Compte;
import com.sdia.ArchitecturesMicroservices.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {


}



