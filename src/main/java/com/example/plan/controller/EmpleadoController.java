/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.controller;


import com.example.plan.entity.Empleado;

import com.example.plan.serviceImpl.EmpleadoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author javier_gr
 */
@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
     @Autowired
    private EmpleadoService empleadoService;
    
    @GetMapping
    public String indexEmpleado(Model model){
        model.addAttribute("empleados", empleadoService.readAll());
        return "empleados/listarEmpleado";
    }
    @GetMapping("/add")
    public String addEmpleado(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("empleado", new Empleado());
        return "empleados/addEmpleado";
    }
    @GetMapping("/save")
    public String saveEmpleado(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("empleado", new Empleado());
        return "empleados/addEmpleado";
    }
    @PostMapping("/save")
    public String addEmpleado(@Valid @ModelAttribute Empleado empleado, BindingResult result, Model model, RedirectAttributes attributes ) {  
        empleadoService.create(empleado);
        return "redirect:/empleado";
    }
    @GetMapping("/edit/{id}")
    public String editarEmpleado(@PathVariable("id") int idempleado, Model model) {  
        Empleado empleado = empleadoService.read(idempleado);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("empleado", empleado);
        return "empleados/addEmpleado";
    }
    @GetMapping("/detalle/{id}")
    public String detalleEmpleado(@PathVariable("id") int idempleado, Model model) {
        
        Empleado empleado = empleadoService.read(idempleado);
        model.addAttribute("titulo", "Detalle");
        model.addAttribute("producto", empleado);
        return "empleados/detallempleado";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmpleado(@PathVariable("id") int idempleado) {  
       empleadoService.delete(idempleado);
        return "redirect:/empleado";
    }
}
