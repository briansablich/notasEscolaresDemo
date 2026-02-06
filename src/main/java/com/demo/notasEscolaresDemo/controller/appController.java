package com.demo.notasEscolaresDemo.controller;

import com.demo.notasEscolaresDemo.service.GeneradorNotas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

@RestController
public class appController {

    private final GeneradorNotas generadorNotas;
    private List<Double> listaNotas;

    public appController(GeneradorNotas generadorNotas) {
        this.generadorNotas = generadorNotas;
        listaNotas = new ArrayList<>();
    }

    @GetMapping("/getNotas")
    public List<Double> getNotas() {
        listaNotas = generadorNotas.getNotas();
        return listaNotas;
    }

    @GetMapping("/getPromedios")
    public Double getPromedios() {
        return listaNotas.stream().mapToDouble(Double::doubleValue).average().orElseThrow();

    }

}
