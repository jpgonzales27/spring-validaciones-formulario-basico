package com.formularios.thymeleaf.manejoformularios.controller;


import com.formularios.thymeleaf.manejoformularios.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;


@Controller
public class UserController {

    @GetMapping("/registrar")
    public String mostrarFormulario(Model model){
        User user = new User();
        model.addAttribute("user",user);

        List<String> listaProfesiones = Arrays.asList("Programador","Tester","Manager");
        model.addAttribute("profesiones",listaProfesiones);

        return "registrar_form";
    }

    /**
     * @Valid especificamos que en este metodo vamos a validar
     *         las especificacion q pusimios en la anotaciones en nuestra clase entity
     *
     *BindingResult permite obtener los errors y mostrarlos
     */
    @PostMapping("/registrar")
    public String submitFormulario(@Valid @ModelAttribute User user, BindingResult bindingResult, Model model){
        System.out.println(user.toString());

        if(bindingResult.hasErrors()){

            List<String> listaProfesiones = Arrays.asList("Programador","Tester","Manager");
            model.addAttribute("profesiones",listaProfesiones);

            return "registrar_form";
        }
        return "registro_success";
    }
}
