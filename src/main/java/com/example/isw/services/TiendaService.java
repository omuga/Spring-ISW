package com.example.isw.services;

import com.example.isw.daos.TiendaRepository;
import com.example.isw.models.Tienda;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service("TiendaService")
public class TiendaService {
    @Autowired
    private TiendaRepository tiendaRepository;

    public Tienda saveTienda (Tienda tienda){
        return tiendaRepository.save(tienda);
    }

    public Tienda findTiendaById(Long id){
        return tiendaRepository.findById(id).orElse(null);
    }

    public Iterable<Tienda> listAllTiendas(){
        return tiendaRepository.findAll();
    }
    
    public  void deleteTienda(Long id){
        tiendaRepository.deleteById(id);
        return;
    }
}