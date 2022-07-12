/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.plan.serviceImpl;

import com.example.plan.entity.Venta;
import java.util.List;

/**
 *
 * @author javier_gr
 */
public interface VentaService {
    Venta create(Venta cliente);
    Venta update(Venta cliente);
    void delete(int id);
    Venta read(int id);
    List<Venta> readAll();
}
