package com.example.proyectobancaingenia.servicebanca.impl;

import com.example.proyectobancaingenia.modelbanca.Cuenta;
import com.example.proyectobancaingenia.modelbanca.Tarjeta;
import com.example.proyectobancaingenia.modelbanca.Usuario;
import com.example.proyectobancaingenia.repositorybanca.TarjetaRepository;
import com.example.proyectobancaingenia.servicebanca.CuentaService;
import com.example.proyectobancaingenia.servicebanca.TarjetaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarjetaServiceImpl implements TarjetaService {

    private final TarjetaRepository tarjetaRepository;
    private final CuentaService cuentaService;

    public TarjetaServiceImpl(TarjetaRepository tarjetaRepository, CuentaService cuentaService) {
        this.tarjetaRepository = tarjetaRepository;
        this.cuentaService = cuentaService;
    }


    //Devuelva las tarjetas de una cuenta por su id
    @Override
    public List<String> tarjetasDeCuentasPorId(Long idCuenta) {

        List<Tarjeta> listadoTarjetas = cuentaService.recuperarCuentaPorId(idCuenta).get().getTarjetas();

        List<String> listadoResultante = new ArrayList<>();

        for (int i = 0; i < listadoTarjetas.size(); i++) {

            listadoResultante.add(listadoTarjetas.get(i).getNumeroTarjeta());
        }
        return listadoResultante;

    }

    @Override
    public List<String> tarjetasPorIdUsuario(Long idUsuario) {

        List<String> listadoResultado = new ArrayList<>();

        for (Cuenta cuenta: cuentaService.listadoCompletoCuentas()) {
            for (Usuario user: cuenta.getUsers()) {
                if(user.getId()== idUsuario){
                    for (Tarjeta tarjeta : cuenta.getTarjetas()) {
                        listadoResultado.add(tarjeta.getNumeroTarjeta());
                    }
                }
            }
        }




        return listadoResultado;
    }
}
