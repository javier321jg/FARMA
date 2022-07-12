/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.repository;

import com.example.plan.entity.Carrito;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author javier_gr
 */
public interface CarritoRepository extends JpaRepository<Carrito, Integer>{
    
}
