package com.example.proyectobancaingenia.repositorybanca;

import com.example.proyectobancaingenia.modelbanca.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
