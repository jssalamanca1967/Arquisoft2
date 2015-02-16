/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.hospitalKennedy.servicios;

import co.edu.uniandes.csw.hospitalKennedy.dto.Paciente;
import co.edu.uniandes.csw.hospitalKennedy.dto.Reporte;
import co.edu.uniandes.csw.hospitalKennedy.logica.interfaces.IServicioPacienteMock;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author estudiante
 */
public class PacienteService {
    
    @EJB
    private IServicioPacienteMock doctorEjb;
    
    @POST
    @Path("agregar/")
    public List<Reporte> agregarPacientes(List<Reporte> lista){
        for(Reporte reporte: lista){
            doctorEjb.agregarReporte(reporte);
        }
        
        return lista;
    }
    
    @DELETE
    @Path("borrar/")
    public void eliminarRecursos(List<Reporte> lista){
        for(Reporte reporte: lista){
            doctorEjb.removerReporte(reporte);
        }
    }
}
