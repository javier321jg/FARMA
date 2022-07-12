/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.controller;

import com.example.plan.entity.Venta;
import com.example.plan.serviceImpl.ClienteService;
import com.example.plan.serviceImpl.EmpleadoService;
import com.example.plan.serviceImpl.VentaService;
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
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;
    @Autowired
    private EmpleadoService empleadoService;
    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public String indexVenta(Model model){
        model.addAttribute("ventas", ventaService.readAll());
        return "ventas/listarVentas";
    }
    @GetMapping("/add")
    public String addVenta(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("venta", new Venta());    
        model.addAttribute("empleados", empleadoService.readAll());
        model.addAttribute("clientes", clienteService.readAll());
        return "ventas/addVentas";
    }
    @GetMapping("/save")
    public String saveVenta(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("venta", new Venta());
        return "ventas/addVentas";
    }
    @PostMapping("/save")
    public String addVenta(@Valid @ModelAttribute Venta venta, BindingResult result, Model model, RedirectAttributes attributes ) {  
        ventaService.create(venta);
        return "redirect:/venta";
    }
    @GetMapping("/edit/{id}")
    public String editarVenta(@PathVariable("id") int idventa, Model model) {  
        Venta venta = ventaService.read(idventa);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("venta", venta);
        model.addAttribute("empleados", empleadoService.readAll());
        model.addAttribute("clientes", clienteService.readAll());
        return "ventas/addVentas";
    }
    @GetMapping("/detalle/{id}")
    public String detalleVenta(@PathVariable("id") int idventa, Model model) {
        
        Venta venta = ventaService.read(idventa);
        model.addAttribute("titulo", "Detalle");
        model.addAttribute("venta", venta);
        return "ventas/detalleVentas";
    }
    @GetMapping("/delete/{id}")
    public String deleteVenta(@PathVariable("id") int idventa) {  
       ventaService.delete(idventa);
        return "redirect:/venta";
    }
    
}
