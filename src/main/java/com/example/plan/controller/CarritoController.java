/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.controller;


import com.example.plan.entity.Carrito;
import com.example.plan.serviceImpl.ProductoService;
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
import com.example.plan.serviceImpl.CarritoService;

/**
 *
 * @author javier_gr
 */
@Controller
@RequestMapping("/carrito")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;
    @Autowired
    private ProductoService productoService;
    @Autowired
    private VentaService ventaService;
    @GetMapping
    public String indexCarrito(Model model){
        model.addAttribute("carritos", carritoService.readAll());
        return "carritos/listarDetalle";
    }
    @GetMapping("/add")
    public String addCarrito(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("carrito", new Carrito());
         model.addAttribute("productos", productoService.readAll());
         model.addAttribute("ventas", ventaService.readAll());
        return "carritos/addDetalle";
    }
    @GetMapping("/save")
    public String saveCarrito(Model model){
        model.addAttribute("titulo", "Registrar");
        model.addAttribute("carrito", new Carrito());
        return "carritos/addDetalle";
    }
    @PostMapping("/save")
    public String addCarrito(@Valid @ModelAttribute Carrito carrito, BindingResult result, Model model, RedirectAttributes attributes ) {  
        carritoService.create(carrito);
        return "redirect:/carrito";
    }
    @GetMapping("/edit/{id}")
    public String editarCarrito(@PathVariable("id") int iddetalle, Model model) {  
        Carrito carrito = carritoService.read(iddetalle);
        model.addAttribute("titulo", "Editar");
        model.addAttribute("carrito", carrito);
         model.addAttribute("productos", productoService.readAll());
         model.addAttribute("ventas", ventaService.readAll());
        
        return "carritos/addDetalle";
    }
    @GetMapping("/detalle/{id}")
    public String detalleCarrito(@PathVariable("id") int iddetalle, Model model) {
        
        Carrito detalle = carritoService.read(iddetalle);
        model.addAttribute("titulo", "Detalle");
        model.addAttribute("producto", detalle);
       return "productos/detalleDetalle";
    }
    @GetMapping("/delete/{id}")
    public String deleteCarrito(@PathVariable("id") int iddetalle) {  
       carritoService.delete(iddetalle);
        return "redirect:/carrito";
    } 
}
