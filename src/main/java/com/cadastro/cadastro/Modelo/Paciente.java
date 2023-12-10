package com.cadastro.cadastro.Modelo;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo inválido")
    @Column
    private String nome;

    @CPF(message = "Cpf inválido")
    @Column
    private String cpf;

    @Size(min = 1, max = 3, message = "Tipo sanguíneo inválido")
    @Column
    private String sangue;

    @Column
    private String alergia;

}
