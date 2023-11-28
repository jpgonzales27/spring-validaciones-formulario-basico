package com.formularios.thymeleaf.manejoformularios.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data // crea los getters y setters
@AllArgsConstructor // crea un constructor con todos los atributos
@NoArgsConstructor // crea un constructor sin atributos
@ToString // crea una implementación del método toString()
public class User {


    @Size(min = 3,max = 50) // fija el tamaño min y max para un atributp
    private String nombre;

    @NotBlank   //no permite el el valor del atributo este en blanco
    @Email(message = "Ingrese un email valido") // valida q el campo este en formato email
    private String email;

    @NotBlank
    @Size(min = 5,max = 15)
    private String password;

    @NotBlank
    private String genero;

    @Size(min=5,max = 100)
    private String nota;

    @AssertTrue
    private boolean matrimonio;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fechaNacimiento;

    @NotBlank
    private String profesion;

    @Min(value = 2000) //el valor minimo q aceptara el campo
    @Max(value = 10000) //el valor maximo q aceptara el campo
    private long ingreso;
}
