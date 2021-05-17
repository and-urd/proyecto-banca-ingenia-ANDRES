package com.example.proyectobancaingenia.servicebanca;

import com.example.proyectobancaingenia.modelbanca.Usuario;

public interface UserService {

    // Comprueba si un user existe por su Id
    boolean existeUserConId(Long id);

    // Crear un usuarios
    Usuario crearUsuario(Usuario usuario);
}
