package br.com.quintino.sistemafinanceiroapi.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PapelImplementationRepository {

    @PersistenceContext
    private EntityManager entityManager;

}
