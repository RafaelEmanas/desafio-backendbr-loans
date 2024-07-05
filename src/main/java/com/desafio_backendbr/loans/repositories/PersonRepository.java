package com.desafio_backendbr.loans.repositories;


import com.desafio_backendbr.loans.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<PersonModel, UUID> {
}
