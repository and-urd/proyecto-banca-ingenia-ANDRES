package com.example.proyectobancaingenia.controllerbanca;

import com.example.proyectobancaingenia.modelbanca.Cuenta;
import com.example.proyectobancaingenia.modelbanca.Movimiento;
import com.example.proyectobancaingenia.modelbanca.Usuario;
import com.example.proyectobancaingenia.servicebanca.CuentaService;
import com.example.proyectobancaingenia.servicebanca.MovimientoService;
import com.example.proyectobancaingenia.servicebanca.TarjetaService;
import com.example.proyectobancaingenia.servicebanca.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
// todo -- @CrossOrigin ........
public class MovimientoController {

    private final MovimientoService movimientoService;
    private final CuentaService cuentaService;
    private final UserService userService;
    private final TarjetaService tarjetaService;

    public MovimientoController(MovimientoService movimientoService, CuentaService cuentaService, UserService userService, TarjetaService tarjetaService) {
        this.movimientoService = movimientoService;
        this.cuentaService = cuentaService;
        this.userService = userService;
        this.tarjetaService = tarjetaService;
    }

//    @GetMapping("movimiento-filtrado/{idUsuario}")
//    public ResponseEntity<List<Movimiento>> movimientoFiltrado(@PathVariable Long idUsuario, @RequestParam Map<String, String> customQuery){
//        return ResponseEntity.ok(movimientoService.recuperaMovimientosPorIdUsuarioFiltrados(idUsuario, customQuery));
//    }

//    @GetMapping("movimiento-filtrado/{idUsuario}")
//    public ResponseEntity<List<Movimiento>> movimientoFiltrado(@PathVariable Long idUsuario, @RequestParam LocalDate fechaOperacion, @RequestParam String tipoCategoria){
//
//        List<Movimiento>movimientosFiltrados = movimientoService.recuperaMovimientosPorIdUsuarioFiltrados(idUsuario, fechaOperacion, tipoCategoria);
//
//        if( ! movimientosFiltrados.isEmpty()){
//            return ResponseEntity.ok().body(movimientosFiltrados);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//    }

    // Devuelve todos los movimientos de la bbdd
    @GetMapping("/movimientos")
    public ResponseEntity<List<Movimiento>> recuperaTodosMovimientos() {
        List<Movimiento> listado = movimientoService.recuperaTodosMovimientos();
        if (!listado.isEmpty()) {
            return ResponseEntity.ok().body(listado);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Devuelve todos los movimientos de un usuario por idUsuario
//    @GetMapping("/movimientos-usuario/{idUsuario}")
//    public ResponseEntity<List<Movimiento>> movimientosPorIdUsuario(@PathVariable Long idUsuario){
//        List<Movimiento> listado = movimientoService.recuperaMovimientosPorIdUsuario(idUsuario);
//        if( ! listado.isEmpty()){
//            return ResponseEntity.ok().body(listado);
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/movimientos-usuario/{idUsuario}")
    public Page<Movimiento> movimientosPorIdUsuario(@PathVariable Long idUsuario, @RequestParam Map<String, String> parametros) {

        int page, size;
        // Valores por defecto para -> page , size
        // Si no está el parámetro `page` por defecto será 0
        page = parametros.containsKey("page") ? Integer.parseInt(parametros.get("page")) : 0;
        // Si no está el parámetro `size`, por defecto será 3
        size = parametros.containsKey("size") ? Integer.parseInt(parametros.get("size")) : 10;


        List<Movimiento> listado = movimientoService.recuperaMovimientosPorIdUsuario(idUsuario);


        if (!listado.isEmpty()) {

            Pageable pageable = PageRequest.of(page, size);
            return convertirListAPage(listado, pageable);
//            return ResponseEntity.ok().body(listado);
        } else {
            return null;
        }
    }

    // Método para convertir una Lista en un objeto Pageable
    public static <T> Page<T> convertirListAPage(List<T> list, Pageable pageable) {
        int inicio = (int) pageable.getOffset();
        int fin = (inicio + pageable.getPageSize()) > list.size() ? list.size() : (inicio + pageable.getPageSize());

        try {
            Page<T> page = new PageImpl<T>(list.subList(inicio, fin), pageable, list.size());
            return page;
        } catch (Exception ex) {
            return null;
        }
    }

    // Recuperamos los movimientos de un usuario (idUsuario) -> filtramos por Cuenta, Tarjeta o global (todos movimientos)
    @GetMapping("movimiento-balance/{idUsuario}")
    public ResponseEntity<List<Movimiento>> movimientoBalance(@PathVariable Long idUsuario, @RequestParam Map<String, String> parametros) {

        // Si no Existe ningún usuario con el idUsuario
        if( ! userService.existeUserConId(idUsuario))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


        // Listado completo cuentas en BBDD
        List<Cuenta> listadoCuentas = cuentaService.listadoCompletoCuentas();

        // Contendrá los movimientos de todas las cuentas del usuario, o sea, el balace GLOBAL
        List<Movimiento> listadoMovimientos = new ArrayList<>();


        // Si NO se pasan parámetros se devuelven los movimientos globales de ese idUsuario
        if (parametros.size() == 0) {
            // Buscamos las cuentas que pertenecen al usuario con idUsuario
            for (Cuenta elementoCuenta : listadoCuentas) { // Para cada Cuenta del listado
                for (Usuario user : elementoCuenta.getUsers()) { // Para cada User de cuenta
                    if (user.getId() == idUsuario) { // Si la cuenta pertenece al usuario idUsuario, agregamos los movimientos de esta cuenta
                        listadoMovimientos.addAll(elementoCuenta.getMovimientos());
                    }
                }
            }

            if (!listadoMovimientos.isEmpty()) {
                return ResponseEntity.ok().body(listadoMovimientos);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }


        // Si se pasan más de dos parámetros devuelve un error
        if (parametros.size() > 1) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        String cuenta; // numero de la cuenta
        String tarjeta; // numero de la tarjeta

        // Si las claves son distintas a: cuenta y tarjeta
        if (parametros.containsKey("cuenta") == false && parametros.containsKey("tarjeta") == false) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        // Si se ha pasado el parámetro cuenta
        if (parametros.containsKey("cuenta")) {
            cuenta = parametros.get("cuenta");

            // Comprobar que la cuenta pasada corresponda al usuario idUsuario
            List<String> listadoNumCuentas = cuentaService.cuentasDeUsuarioPorId(idUsuario);
            if(listadoNumCuentas.contains(cuenta) == false){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            for (Cuenta elementoCuenta : listadoCuentas) { // Para cada Cuenta del listado

                if (elementoCuenta.getNumeroCuenta().equals(cuenta)) { // Si coincide con la cuenta pasada por parámetro
                    listadoMovimientos.addAll(elementoCuenta.getMovimientos()); // Añadimos al listado resultante
                }
            }

            if (!listadoMovimientos.isEmpty()) {
                return ResponseEntity.ok().body(listadoMovimientos);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        // Si se ha pasado el parámetro tarjeta
        if(parametros.containsKey("tarjeta")) {
            tarjeta = parametros.get("tarjeta");



            // Comprobar que la tarjeta pasada por parámetro corresponda al usuario idUsuario
            List<String> listadoNumTarjeta = tarjetaService.tarjetasPorIdUsuario(idUsuario);
            if(listadoNumTarjeta.contains(tarjeta) == false){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }




            for (Cuenta elementoCuenta : listadoCuentas) { // Para cada Cuenta del listado
                for (Usuario user : elementoCuenta.getUsers()) { // Para cada User de cuenta
                    if (user.getId() == idUsuario) { // Si la cuenta pertenece al usuario idUsuario, agregamos los movimientos de esta cuenta

                        for (Movimiento movimiento : elementoCuenta.getMovimientos()) {
                            if(movimiento.getNumTarjeta().equals(tarjeta)){
                                listadoMovimientos.add(movimiento);
                            }
                        }

                    }
                }
            }


            if (!listadoMovimientos.isEmpty()) {
                return ResponseEntity.ok().body(listadoMovimientos);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }



        }

        return null;
    }



}
