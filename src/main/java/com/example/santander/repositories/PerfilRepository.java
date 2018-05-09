package com.example.santander.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.santander.models.Perfil;

@Repository
public interface PerfilRepository extends MongoRepository<Perfil, String> {
}
