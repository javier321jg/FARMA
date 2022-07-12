/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Carrito;

import java.util.List;

/**
 *
 * @author javier_gr
 */
public interface CarritoService {
    Carrito create(Carrito venta);
    Carrito update(Carrito venta);
    void delete(int id);
    Carrito read(int id);
    List<Carrito> readAll();
    
}
