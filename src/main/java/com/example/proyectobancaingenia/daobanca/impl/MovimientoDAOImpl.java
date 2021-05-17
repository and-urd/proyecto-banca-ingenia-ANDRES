//package com.example.proyectobancaingenia.daobanca.impl;
//
//import com.example.proyectobancaingenia.daobanca.MovimientoDAO;
//import com.example.proyectobancaingenia.modelbanca.Categoria;
//import com.example.proyectobancaingenia.modelbanca.Movimiento;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class MovimientoDAOImpl implements MovimientoDAO {
//
//    @PersistenceContext
//    private EntityManager manager;
//
//    @Override
//    public List<Movimiento> movimientosFiltrados(Map<String, String> customQuery) {
//        CriteriaBuilder cb = manager.getCriteriaBuilder();
//        CriteriaQuery<Movimiento> cq =cb.createQuery(Movimiento.class);
//        Root<Movimiento> movimientoRoot = cq.from(Movimiento.class);
//        List predicados = new ArrayList();
//        if (customQuery.containsKey("fechaOperacion")) {
//            Predicate predicadoFechaOperacion = cb.like(movimientoRoot.get("fechaOperacion"), customQuery.get("fechaOperacion"));
//            predicados.add(predicadoFechaOperacion);
//        }
//        if (customQuery.containsKey("categoria")) {
//            Join<Movimiento, Categoria> categoria = movimientoRoot.join("categoria");
//            Expression<String> expression = categoria.get("tipoCategoria");
//            Predicate predicadoCategoria = cb.like(expression, customQuery.get("categoria"));
//            predicados.add(predicadoCategoria);
//        }
//            //Convierto la lista de predicados a un array
//            Predicate[] arrayPredicados = (Predicate[]) predicados.toArray(new Predicate[0]);
//            cq.where(arrayPredicados);
//            return manager.createQuery(cq).getResultList();
//    }
//}
