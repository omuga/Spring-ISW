package com.example.isw.controllers;
import com.example.isw.models.Tienda;
import com.example.isw.services.TiendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/tiendas")
@CrossOrigin(origins = "*")
public class TiendaController {
    
    @Autowired
    @Qualifier("TiendaService")
    private TiendaService tiendaService;

    @GetMapping("")
    public Iterable<Tienda> getTiendas(){
        return tiendaService.listAllTiendas();
    }

    @GetMapping("/{id}")
    public ResponseEntity getTienda(@PathVariable Long id){
        Tienda tienda = tiendaService.findTiendaById(id);
        if (tienda != null){
            return new ResponseEntity<Tienda>(tienda, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    public ResponseEntity<Tienda> createTienda(@RequestBody Tienda tienda){
        /*Tienda tienda = new Tienda();
        tienda.setNombre(nombre);
        tienda.setDireccion(direccion);*/
        tiendaService.saveTienda(tienda);
        return new ResponseEntity<Tienda>(tienda,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTienda(@PathVariable Long id){
        Tienda tienda = tiendaService.findTiendaById(id);
        if (tienda != null){
            tiendaService.deleteTienda(id);
            return new ResponseEntity<>(true,HttpStatus.ACCEPTED);
        } else{
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

}