package com.sdia.ArchitecturesMicroservices.entities;


import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = Compte.class,name = "p2")
public interface CompteProjections2 {
        public Long getId();
        public Double getSolde();
        public Date getDateCreation();
}
