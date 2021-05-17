package com.example.proyectobancaingenia.servicebanca.impl;

import com.example.proyectobancaingenia.modelbanca.Cuenta;
import com.example.proyectobancaingenia.modelbanca.Usuario;
import com.example.proyectobancaingenia.repositorybanca.CuentaRepository;
import com.example.proyectobancaingenia.servicebanca.CuentaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements CuentaService {

    // Inyección del repositorio
    private final CuentaRepository cuentaRepository;

    public CuentaServiceImpl(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;
    }

    // Devuelve una cuenta por ID
    @Override
    public Optional<Cuenta> recuperarCuentaPorId(Long id) {
        return cuentaRepository.findById(id);
    }




    // Devuelve las cuentas de un usuario por su id
    @Override
    public List<String> cuentasDeUsuarioPorId(Long idUsuario) {

        List<Cuenta> listadoCuentas = cuentaRepository.findAll();

        List<String> listadoResultante = new ArrayList<>();

        for (int i = 0; i < listadoCuentas.size(); i++) {

            List<Usuario> listadoUsers = listadoCuentas.get(i).getUsers();

            for (int j = 0; j < listadoUsers.size(); j++) {
                if (listadoUsers.get(j).getId() == idUsuario)
                    listadoResultante.add(listadoCuentas.get(i).getNumeroCuenta());
            }
        }

        return listadoResultante;
    }

    // Devuelve el saldo de una cuenta por numero de cuenta
    @Override
    public Double saldoDeCuenta(String numCuenta) {
        List<Cuenta> listadoCuentas = cuentaRepository.findAll();

        Double saldoResultante = 0.0;

        for (int i = 0; i < listadoCuentas.size(); i++) {

            if (listadoCuentas.get(i).getNumeroCuenta().equals(numCuenta)) {
                saldoResultante = listadoCuentas.get(i).getSaldo();
            }
//            List<User> listadoUsers = listadoCuentas.get(i).getUsers();
//
//            for (int j = 0; j < listadoUsers.size(); j++) {
//                if(listadoUsers.get(j).getId() == idUsuario)
//                    listadoResultante.add(listadoCuentas.get(i).getNumeroCuenta());
//            }
        }

        return saldoResultante;

    }




    @Override
    public List<Cuenta> listadoCompletoCuentas() {
        return cuentaRepository.findAll();
    }

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {
        if(cuenta.getId() == null){
            return cuentaRepository.save(cuenta);
        }else{
            return null;
        }
    }


}
