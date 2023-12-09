package com.cadastro.cadastro.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.cadastro.DTO.PacienteDto;
import com.cadastro.cadastro.Modelo.Paciente;
import com.cadastro.cadastro.Repository.RepositoryPaciente;

import jakarta.transaction.Transactional;

@Service
public class PacienteService {

    @Autowired
    private RepositoryPaciente repositoryPaciente;

    public Paciente criarCadastro(Paciente paciente) {
        return repositoryPaciente.save(paciente);
    }

    @Transactional
    public Optional<PacienteDto> findDtoById(Long id) {
        return repositoryPaciente.findById(id)
                .map(paciente -> new PacienteDto(paciente.getId(), paciente.getNome(), paciente.getSangue(),
                        paciente.getAlergia()));
    }
}
