package com.cadastro.cadastro.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastro.cadastro.DTO.PacienteDto;
import com.cadastro.cadastro.Modelo.Paciente;
import com.cadastro.cadastro.Repository.RepositoryPaciente;

@Service
public class PacienteService {

    @Autowired
    private RepositoryPaciente repositoryPaciente;

    public List<PacienteDto> listarPacientes() {
        return repositoryPaciente.findAll().stream().map(paciente -> PacienteDto.convert(paciente))
                .collect(Collectors.toList());
    }

    public Paciente criarCadastro(Paciente paciente) {
        return repositoryPaciente.save(paciente);
    }

    public Paciente alterarPaciente(Long id, Paciente paciente) {
        Paciente pacienteEditar = repositoryPaciente.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        pacienteEditar.setNome(paciente.getNome());
        pacienteEditar.setSangue(paciente.getSangue());
        pacienteEditar.setAlergia(paciente.getAlergia());
        return repositoryPaciente.save(pacienteEditar);
    }

    public void deletarPorId(Long id) {
        repositoryPaciente.deleteById(id);
    }

    public PacienteDto buscar(Long id) {
        Paciente paciente = repositoryPaciente.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        return PacienteDto.convert(paciente);
    }
}