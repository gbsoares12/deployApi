/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.sc.ibirama.RotaAPI.resources;

import br.gov.sc.ibirama.RotaAPI.model.Rota;
import br.gov.sc.ibirama.RotaAPI.repositorio.RotaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Gabriel Soares
 */
@CrossOrigin(origins = "http://localhost:4200") //Configura o crossOrigin, libera o bloqueio do header
@RestController
@RequestMapping("/rotasIbirama")
public class RotaResources {

    @Autowired
    private RotaRepositorio rr;

    @GetMapping
    public List<Rota> find() {
        return rr.findAll();
    }

    @CrossOrigin
    @GetMapping("/filter")
    public List<Rota> findSingleFilter(@RequestParam(name = "rua", required = false) String rua, @RequestParam(name = "bairro", required = false) String bairro, @RequestParam(name = "coleta", required = false) String tipoColeta) {

        if ((rua != null && bairro != null) && (!rua.equals("") && !bairro.equals("") && tipoColeta.equalsIgnoreCase("undefined"))) {
            return rr.buscarRotaPeloBairroERua(bairro, rua);
        }
        if ((rua != null && bairro != null) && rua.equals("") && !bairro.equals("") && tipoColeta.equalsIgnoreCase("undefined")) {
            return rr.buscarRotaPeloBairro(bairro);
        }
        if ((rua != null && bairro != null) && !rua.equals("") && bairro.equals("") && tipoColeta.equalsIgnoreCase("undefined")) {
            return rr.buscarRotaPelaRua(rua);
        }
        if ((rua != null && bairro != null) && !rua.equals("") && !bairro.equals("") && !tipoColeta.equalsIgnoreCase("undefined")) {
            return rr.buscarRotaPeloBairroRuaColeta(bairro, rua, tipoColeta);
        }
        if ((rua != null && bairro != null) && !rua.equals("") && bairro.equals("") && !tipoColeta.equalsIgnoreCase("undefined")) {
            return rr.buscarRotaPelaRuaEColeta(rua, tipoColeta);
        }
        if ((rua != null && bairro != null) && rua.equals("") && !bairro.equals("") && !tipoColeta.equalsIgnoreCase("undefined")) {
            return rr.buscarRotaPeloBairroEColeta(bairro, tipoColeta);
        }
        if ((tipoColeta != null) && !tipoColeta.equalsIgnoreCase("undefined")) {
            return rr.buscarRotaPelaColeta(tipoColeta);
        }
        return null;
    }

}
