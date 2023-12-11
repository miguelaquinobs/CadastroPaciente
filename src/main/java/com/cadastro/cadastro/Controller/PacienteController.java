package com.cadastro.cadastro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.cadastro.DTO.PacienteDto;
import com.cadastro.cadastro.Modelo.Paciente;
import com.cadastro.cadastro.Service.PacienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Validated
@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<PacienteDto> listar() {
        return pacienteService.listarPacientes();

    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public PacienteDto findDtoById(@PathVariable Long id) {
        return pacienteService.buscar(id);

    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Paciente cadastrar(@RequestBody @Valid Paciente paciente) {
        return pacienteService.criarCadastro(paciente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public Paciente alterarPaciente(@PathVariable Long id, @RequestBody Paciente paciente) {
        return pacienteService.alterarPaciente(id, paciente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        pacienteService.deletarPorId(id);
    }
}