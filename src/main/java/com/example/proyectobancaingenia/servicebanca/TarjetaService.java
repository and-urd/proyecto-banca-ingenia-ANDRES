package com.example.proyectobancaingenia.servicebanca;

import com.example.proyectobancaingenia.modelbanca.Tarjeta;

import java.util.List;

public interface TarjetaService {

    List<String> tarjetasDeCuentasPorId (Long idCuenta);

    List<String> tarjetasPorIdUsuario (Long idUsuario);
}
