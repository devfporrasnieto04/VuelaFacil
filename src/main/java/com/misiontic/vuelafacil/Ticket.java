/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.vuelafacil;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author franciscoporrasnieto
 */
@Table 
@Entity(name="Ticket")
//@Embeddable
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idTicket")
    private Integer idTicket;
    @Column(name="precio")
    private Double precio;
    @Column(name="fechaVueloIda")
    private LocalDateTime fechaVueloIda;
    @Column (name="fechaVueloRegreso")
    private LocalDateTime fechaVueloRegreso;
    @Column (name="numAsiento")
    private Integer numAsiento;
    @Column (name="clase")
    private String clase;
    @Column (name="equipaje")
    private String equipaje;
   
    @ManyToOne
    @JoinColumn (name="usuario_idUsuario")
    private Usuario usuario_idUsuario;
    
    @ManyToOne
    @JoinColumn (name="Vuelo_idVuelo")
    private Vuelo Vuelo_idVuelo;
    
    @ManyToOne
    @JoinColumn(name="Aeropuerto_idAeropuerto")
    private Aeropuerto Aeropuerto_idAeropuerto;

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaVueloIda() {
        return fechaVueloIda;
    }

    public void setFechaVueloIda(LocalDateTime fechaVueloIda) {
        this.fechaVueloIda = fechaVueloIda;
    }

    public LocalDateTime getFechaVueloRegreso() {
        return fechaVueloRegreso;
    }

    public void setFechaVueloRegreso(LocalDateTime fechaVueloRegreso) {
        this.fechaVueloRegreso = fechaVueloRegreso;
    }

    public Integer getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(Integer numAsiento) {
        this.numAsiento = numAsiento;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getEquipaje() {
        return equipaje;
    }

    public void setEquipaje(String equipaje) {
        this.equipaje = equipaje;
    }

    public Usuario getUsuario_idUsuario() {
        return usuario_idUsuario;
    }

    public void setUsuario_idUsuario(Usuario usuario_idUsuario) {
        this.usuario_idUsuario = usuario_idUsuario;
    }

    public Vuelo getVuelo_idVuelo() {
        return Vuelo_idVuelo;
    }

    public void setVuelo_idVuelo(Vuelo Vuelo_idVuelo) {
        this.Vuelo_idVuelo = Vuelo_idVuelo;
    }

    public Aeropuerto getAeropuerto_idAeropuerto() {
        return Aeropuerto_idAeropuerto;
    }

    public void setAeropuerto_idAeropuerto(Aeropuerto Aeropuerto_idAeropuerto) {
        this.Aeropuerto_idAeropuerto = Aeropuerto_idAeropuerto;
    }
    
    
}
