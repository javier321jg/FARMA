/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Carrito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.plan.repository.CarritoRepository;

/**
 *
 * @author javier_gr
 */
@Service
public class CarritoServiceImpl implements CarritoService{
@Autowired
    private CarritoRepository carritoRepository;
    @Override
    public Carrito create(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public Carrito update(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public void delete(int id) {
        carritoRepository.deleteById(id);
    }

    @Override
    public Carrito read(int id) {
        return carritoRepository.findById(id).get();
        }

    @Override
    public List<Carrito> readAll() {
        return carritoRepository.findAll();
        }
    
    
}
