package com.example.proyectobancaingenia.modelbanca;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="tarjetas")
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="numero_tarjeta")
    private String numeroTarjeta;

    @Column(name="fecha_caducidad")
    private LocalDate fechaCaducidad;

    private Integer cvv;

    @Column(name="limite_maximo")
    private Double limiteMaximo;

    @Column(name = "tipo_tarjeta")
    private String tipoTarjeta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_cuenta")
    private Cuenta cuenta;

    // CONSTRUCTORES

    public Tarjeta() {
    }

    public Tarjeta(String numeroTarjeta, LocalDate fechaCaducidad, Integer cvv, Double limiteMaximo, String tipoTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaCaducidad = fechaCaducidad;
        this.cvv = cvv;
        this.limiteMaximo = limiteMaximo;
        this.tipoTarjeta = tipoTarjeta;

        // TODO - faltan campos FK
    }

    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Double getLimiteMaximo() {
        return limiteMaximo;
    }

    public void setLimiteMaximo(Double limiteMaximo) {
        this.limiteMaximo = limiteMaximo;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    // TODO - faltan campos FK

    // METODO TOSTRING

    @Override
    public String toString() {
        return "Tarjeta{" +
                "id=" + id +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", fechaCaducidad=" + fechaCaducidad +
                ", cvv=" + cvv +
                ", limiteMaximo=" + limiteMaximo +
                ", tipoTarjeta='" + tipoTarjeta + '\'' +
                '}';

        // TODO - faltan campos FK
    }
}
