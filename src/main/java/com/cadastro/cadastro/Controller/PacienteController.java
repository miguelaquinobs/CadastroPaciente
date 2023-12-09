package com.cadastro.cadastro.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.cadastro.DTO.PacienteDto;
import com.cadastro.cadastro.Modelo.Paciente;
import com.cadastro.cadastro.Repository.RepositoryPaciente;
import com.cadastro.cadastro.Service.PacienteService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private RepositoryPaciente repository;
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<PacienteDto> listar() {
        List<Paciente> paciente = repository.findAll();
        return PacienteDto.convert(paciente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> findDtoById(@PathVariable Long id) {
        Optional<PacienteDto> pacienteDtoOptional = pacienteService.findDtoById(id);

        return pacienteDtoOptional
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void cadastrar(@RequestBody Paciente paciente) {
        repository.save(paciente);
    }

    @PutMapping
    public void alterar(@RequestBody Paciente paciente) {
        repository.save(paciente);
    }

    @DeleteMapping
    public void deletar(@RequestBody Paciente paciente) {
        repository.delete(paciente);
    }
}
