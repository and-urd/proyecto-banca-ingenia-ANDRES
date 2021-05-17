package com.example.proyectobancaingenia.servicebanca;

import com.example.proyectobancaingenia.modelbanca.Categoria;
import com.example.proyectobancaingenia.modelbanca.Movimiento;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MovimientoService {

//    List<Movimiento>recuperaMovimientosPorIdUsuarioFiltrados(Long id, Map<String, String> customQuery);
//    List<Movimiento> recuperaMovimientosPorIdUsuarioFiltrados(Long id, LocalDate fechaOperacion, String categoria);

    // Recupera movimientos de un usuario por id
    List<Movimiento> recuperaMovimientosPorIdUsuario(Long idUsuario);

    // Recupera todos los movimientos de la bbdd
    List<Movimiento> recuperaTodosMovimientos();

    // Recupera movimiento por su id
    Optional<Movimiento> movimientoPorId(Long id);
}
