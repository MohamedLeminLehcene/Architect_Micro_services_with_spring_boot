package com.sdia.ArchitecturesMicroservices.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(types = Compte.class,name = "p1")
public interface CompteProjections1 {
        public Long getId();
        public Double getSolde();
}
