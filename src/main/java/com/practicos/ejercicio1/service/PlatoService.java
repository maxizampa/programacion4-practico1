package com.practicos.ejercicio1.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.practicos.ejercicio1.model.Plato;
import com.practicos.ejercicio1.repository.*;


import java.util.List;


@Service
public class PlatoService {

    private PlatoRepository platoRepository;

        //agrego el repositorio para guardar los platos
    public PlatoService(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    // alta de los platos
    public void registrarPlato(Plato plato) {
        validarCamposObligatorios(plato);

        // Verificamos que el número de plato no esté repetido en la lista 
        if (platoRepository.buscarPorNumeroPlato(plato.getNumeroPlato()).isPresent()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, 
                "Error: Ya existe un plato con el número " + plato.getNumeroPlato()
            );
        }

        platoRepository.agregarPlato(plato);
    }

    // Toda la lista
    public List<Plato> listarTodos() {
        return platoRepository.obtenerTodos();
    }

    // Busca un plato por su nro 
    public Plato buscarPorNumero(Integer numero) {
        return platoRepository.buscarPorNumeroPlato(numero)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "El plato número " + numero + " no fue encontrado"
                ));
    }



    //valido los campos 
    private void validarCamposObligatorios(Plato plato) {
       if (plato.getNumeroPlato() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falta el numero");
        }
        
        if (plato.getNombrePlato() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falta el nombre");
        }

        if (plato.getPrecioPlato() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falta el precio");
        }

        if (plato.getPrecioPlato() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El precio debe ser positivo");
        }

        if (plato.getNombrePlato().length() < 3) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre es muy corto");
        }

        if (plato.getDescripcionPlato() != null && plato.getDescripcionPlato().length() > 200) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La descripción es demasiado larga");
        }
    }


}
