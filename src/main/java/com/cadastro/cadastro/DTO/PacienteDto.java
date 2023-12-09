package com.cadastro.cadastro.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.cadastro.cadastro.Modelo.Paciente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {

    private Long id;
    private String nome;
    private String sangue;
    private String alergia;

    public PacienteDto(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.sangue = paciente.getSangue();
        this.alergia = paciente.getAlergia();
    }

    public static List<PacienteDto> convert(List<Paciente> paciente) {
        return paciente.stream().map(PacienteDto::new).collect(Collectors.toList());
    }

}
