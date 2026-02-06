package com.demo.notasEscolaresDemo.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.DoubleStream;

@Service
public class GeneradorNotas {

    public List<Double> getNotas() {
        return DoubleStream.generate(() -> Math.random() * 10 + 1)
                .limit(8)
                .map(nota -> Math.round(nota * 10.0) /10.0)
                .boxed()
                .toList();        // Lo transforma en una lista
    }

}
