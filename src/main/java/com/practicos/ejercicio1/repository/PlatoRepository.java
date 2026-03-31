package com.practicos.ejercicio1.repository;

import com.practicos.ejercicio1.model.Plato;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepository {

    private List<Plato> platos = new ArrayList<>();

    //agrego platos a la lista
    public void agregarPlato(Plato plato) {
        platos.add(plato);
    }

    public List<Plato> obtenerTodos() {
        return platos;
    }

    //usamos optional para evitar el nullpointerexception entre otras cosas
    public Optional<Plato> buscarPorNumeroPlato(Integer numeroPlato) {
        for (Plato p : platos) {
            if (p.getNumeroPlato().equals(numeroPlato)) {
                return Optional.of(p); 
            }
        }
        return Optional.empty();
    }
}
