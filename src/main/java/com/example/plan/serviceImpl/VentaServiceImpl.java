/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Venta;
import com.example.plan.repository.VentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author javier_gr
 */
@Service
public class VentaServiceImpl implements VentaService{
    @Autowired
private VentaRepository ventaRepository;
    @Override
    public Venta create(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public Venta update(Venta venta) {
       return ventaRepository.save(venta);
    }

    @Override
    public void delete(int id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public Venta read(int id) {
        return ventaRepository.findById(id).get();
    }

    @Override
    public List<Venta> readAll() {
        return ventaRepository.findAll();
    }
   
    
}
