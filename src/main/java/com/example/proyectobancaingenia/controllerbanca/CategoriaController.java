package com.example.proyectobancaingenia.controllerbanca;

import com.example.proyectobancaingenia.modelbanca.Categoria;
import com.example.proyectobancaingenia.modelbanca.Movimiento;
import com.example.proyectobancaingenia.servicebanca.MovimientoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoriaController {

    // Inyección del servicio Movimiento
    private final MovimientoService movimientoService;
    public CategoriaController(MovimientoService movimientoService) {
        this.movimientoService = movimientoService;
    }

    // Devuelve la categoria de un movimiento
    @GetMapping("/categoria/{idMovimiento}")
    public ResponseEntity<String> categoriaDeMovimiento(@PathVariable Long idMovimiento){

        Optional<Movimiento> movimiento = movimientoService.movimientoPorId(idMovimiento);
        String categoriaResultado = "";

        if(movimiento.isPresent()){
            categoriaResultado = movimiento.get().getCategoria().getTipoCategoria();
            return ResponseEntity.ok().body(categoriaResultado);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
