package com.cadastro.cadastro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cadastro.cadastro.DTO.PacienteDto;
import com.cadastro.cadastro.Modelo.Paciente;
import com.cadastro.cadastro.Repository.RepositoryPaciente;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {


        @Autowired
        private RepositoryPaciente repository;

        @GetMapping
        public List <PacienteDto> listar(){
            List<Paciente> paciente = repository.findAll();
            return PacienteDto.convert(paciente);
        }
        
        @PostMapping
        public void cadastrar(@RequestBody Paciente paciente){
            repository.save(paciente);
        }

        @PutMapping
        public void alterar(@RequestBody Paciente paciente){
            repository.save(paciente);
        }

        @DeleteMapping
        public void deletar(@RequestBody Paciente paciente){
            repository.delete(paciente);
        }
}
