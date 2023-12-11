package com.cadastro.cadastro.DTO;

import com.cadastro.cadastro.Modelo.Paciente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {

    private Long id;
    private String nome;
    private String sangue;
    private String alergia;

    public static PacienteDto convert(Paciente paciente) {
        return PacienteDto.builder()
                .id(paciente.getId())
                .nome(paciente.getNome())
                .sangue(paciente.getSangue())
                .alergia(paciente.getAlergia()).build();
    }

}
