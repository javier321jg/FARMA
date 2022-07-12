/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Cliente;
import java.util.List;

/**
 *
 * @author javier_gr
 */
public interface ClienteService {
   Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
    void delete(int id);
    Cliente read(int id);
    List<Cliente> readAll();
    
    
}