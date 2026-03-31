package com.practicos.ejercicio1.controller;

import com.practicos.ejercicio1.model.Plato;
import com.practicos.ejercicio1.service.PlatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {

    private final PlatoService platoService;

    // servicio 
    public PlatoController(PlatoService platoService) {
        this.platoService = platoService;
    }

    // post alta de plato
    @PostMapping
    public void crearPlato(@RequestBody Plato plato) {
        platoService.registrarPlato(plato);
    }

    // Get todos los platos
    @GetMapping
    public List<Plato> obtenerTodos() {
        return platoService.listarTodos();
    }

    // Get por numero de plato 
    @GetMapping("/{numero}")
    public Plato obtenerPorNumero(@PathVariable Integer numero) {
        return platoService.buscarPorNumero(numero);
    }
}