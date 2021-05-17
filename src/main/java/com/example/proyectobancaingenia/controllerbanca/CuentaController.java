package com.example.proyectobancaingenia.controllerbanca;

import com.example.proyectobancaingenia.modelbanca.Cuenta;
import com.example.proyectobancaingenia.servicebanca.CuentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
// todo -- @CrossOrigin......
public class CuentaController {
    private final Logger  log = LoggerFactory.getLogger (CuentaController.class);

    // Inyecto cuentaService
    private final CuentaService cuentaService;
    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    // Recupera las cuentas de un usuario por su id
    // Devuelve un listado(string) de los numeros de cuenta
    @GetMapping("/cuenta-numeroscuenta/{id}")
    public ResponseEntity<List<String>> cuentasDeUsuarioPorId(@PathVariable Long id){


        List<String> listadoCuentas = cuentaService.cuentasDeUsuarioPorId(id);

        if(listadoCuentas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(listadoCuentas);
        }
    }


    // Obtenemos el saldo de una cuenta por su numero de cuenta(String)
    @GetMapping("/cuenta-saldo/{numCuenta}")
    public ResponseEntity<Double> saldoDeCuenta(@PathVariable String numCuenta){

        Double saldo = cuentaService.saldoDeCuenta(numCuenta);

        if(saldo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(saldo);
        }
    }



    // Recuperamos todas las cuentas existentes en la BBDD
    @GetMapping("cuentas")
    public ResponseEntity<List<Cuenta>> listadoCompletoCuentas(){
        List<Cuenta> listado = cuentaService.listadoCompletoCuentas();

        if(listado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok().body(listado);
        }
    }


    // Crea una nueva cuenta
    @PostMapping("cuenta-crear")
    public ResponseEntity<Cuenta> crearCuenta(@RequestBody Cuenta cuenta){
        Cuenta cuentaCreada = cuentaService.crearCuenta(cuenta);

        if(cuentaCreada == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else{
            return ResponseEntity.ok().body(cuentaCreada);
        }
    }


}
