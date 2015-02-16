/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.hospitalKennedy.dto;

import java.util.Date;

/**
 *
 * @author estudiante
 */
public class Reporte {
    
    private String actividadFisica;
    private String alimentacion;
    private String gravedad;
    private Date fechaCreacion;
    private Long id;
    private String localizacionDolor;
    private String patronSuenio;
    private int numeroIdentificacion;
    
    public Reporte(){
        
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setActividadFisica(String actividadFisica) {
        this.actividadFisica = actividadFisica;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLocalizacionDolor(String localizacionDolor) {
        this.localizacionDolor = localizacionDolor;
    }

    public void setPatronSuenio(String patronSuenio) {
        this.patronSuenio = patronSuenio;
    }

    public String getActividadFisica() {
        return actividadFisica;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public String getGravedad() {
        return gravedad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Long getId() {
        return id;
    }

    public String getLocalizacionDolor() {
        return localizacionDolor;
    }

    public String getPatronSuenio() {
        return patronSuenio;
    }
    
}
