/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Empleado;
import com.example.plan.repository.EmpleadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author javier_gr
 */
@Service
public class EmpleadoServiceIpml implements EmpleadoService{
@Autowired
    private EmpleadoRepository empleadoRepository;
    @Override
    public Empleado create(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado update(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void delete(int id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public Empleado read(int id) {
        return empleadoRepository.findById(id).get();
    }

    @Override
    public List<Empleado> readAll() {
       return empleadoRepository.findAll();
    }
    
}
