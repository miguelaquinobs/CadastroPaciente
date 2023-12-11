package com.cadastro.cadastro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cadastro.cadastro.Modelo.Paciente;

@Repository
public interface RepositoryPaciente extends JpaRepository<Paciente, Long> {

}
