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
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author estudiante
 */
@Path("/Pacientes")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PacienteService {
    
    @EJB
    private IServicioPacienteMock doctorEjb;
    
    @POST
    @Path("agregar/")
    public List<Reporte> agregarPacientes(List<Reporte> lista){
                System.out.println("Mensajeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

        for(Reporte reporte: lista){
            doctorEjb.agregarReporte(reporte);
        }

        
        return lista;
    }
    
    @DELETE
    @Path("borrar/")
    public void eliminarRecursos(List<Reporte> lista) throws Exception{
        for(Reporte reporte: lista){
            doctorEjb.removerReporte(reporte);
        }
                throw new Exception("asdasdasdasdasd");

    }
}
