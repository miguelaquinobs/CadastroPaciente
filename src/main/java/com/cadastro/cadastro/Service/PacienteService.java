package com.cadastro.cadastro.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.cadastro.Modelo.Paciente;
import com.cadastro.cadastro.Repository.RepositoryPaciente;

@Service
public class PacienteService {

    @Autowired
    private RepositoryPaciente repositoryPaciente;

    public Paciente criarCadastro(Paciente paciente){
    return repositoryPaciente.save(paciente);
    }
}
