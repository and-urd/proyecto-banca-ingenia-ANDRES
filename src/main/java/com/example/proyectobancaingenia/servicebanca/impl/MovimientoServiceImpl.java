package com.example.proyectobancaingenia.servicebanca.impl;

//import com.example.proyectobancaingenia.daobanca.MovimientoDAO;
import com.example.proyectobancaingenia.modelbanca.Cuenta;
import com.example.proyectobancaingenia.modelbanca.Movimiento;
import com.example.proyectobancaingenia.modelbanca.Usuario;
import com.example.proyectobancaingenia.repositorybanca.MovimientoRepository;
import com.example.proyectobancaingenia.servicebanca.MovimientoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    //Inyección del repositorio
    private final MovimientoRepository movimientoRepository;
//    private final MovimientoDAO movimientoDAO;

    public MovimientoServiceImpl(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }


    /*
    Recuperar Movimientos por IdUsuario y filtralos por Mes, Año y Categoria
     */
//    @Override
//    public List<Movimiento> recuperaMovimientosPorIdUsuarioFiltrados(Long id, Map<String, String> customQuery) {
//        if (recuperaMovimientosPorIdUsuario(id) == null){
//            return null;
//        }
//        return movimientoDAO.movimientosFiltrados(customQuery);
//    }


//    @Override
//    public List<Movimiento> recuperaMovimientosPorIdUsuarioFiltrados(Long id, LocalDate fechaOperacion, String tipoCategoria) {
//        List <Movimiento> movimientosPorIdUsuario = recuperaMovimientosPorIdUsuario(id);
//        List <Movimiento> movimientosResultado = new ArrayList<>();
//
//        for (int i = 0; i < movimientosPorIdUsuario.size(); i++) {
//
//            if(fechaOperacion ==  movimientosPorIdUsuario.get(i).getFechaOperacion()
//              && tipoCategoria.equals(movimientosPorIdUsuario.get(i).getCategoria().getTipoCategoria())){
//                movimientosResultado.add(movimientosPorIdUsuario.get(i));
//            }
//        }
//        return movimientosResultado;
//    }


    @Override
    public List<Movimiento> recuperaMovimientosPorIdUsuario(Long idUsuario) {

        // Todos los movimientos de la BBDD
        List<Movimiento> listMovimientos = movimientoRepository.findAll();

        // Aquí se guardarán los movimientos del usuario con id=idUsuario
        List<Movimiento> listResultado = new ArrayList<>();

        for (int i = 0; i < listMovimientos.size(); i++) {

            Cuenta cuenta = listMovimientos.get(i).getCuenta();

            List<Usuario> listadoUsuarios = cuenta.getUsers();

            for (int j = 0; j < listadoUsuarios.size(); j++) {
                if(listadoUsuarios.get(j).getId() == idUsuario)
                    listResultado.add(listMovimientos.get(i));
            }

        }
        return listResultado;
    }

    @Override
    public List<Movimiento> recuperaTodosMovimientos() {
        return movimientoRepository.findAll();
    }

    @Override
    public Optional<Movimiento> movimientoPorId(Long id) {

        Optional<Movimiento> movimiento = movimientoRepository.findById(id);

        return movimiento;
    }
}
