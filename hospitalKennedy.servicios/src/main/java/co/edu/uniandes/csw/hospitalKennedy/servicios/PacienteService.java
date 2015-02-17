/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.hospitalKennedy.servicios;

import co.edu.uniandes.csw.hospitalKennedy.dto.Paciente;
import co.edu.uniandes.csw.hospitalKennedy.dto.Reporte;
import co.edu.uniandes.csw.hospitalKennedy.logica.interfaces.IServicioPacienteMock;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    private IServicioPacienteMock pacienteEjb;
    
    @POST
    @Path("agregar/")
    public List<Reporte> agregarPacientes(List<Reporte> lista){

        for(Reporte reporte: lista){
            pacienteEjb.agregarReporte(reporte);
        }

        
        return lista;
    }
    
    @DELETE
    @Path("borrar/")
    public void eliminarRecursos(List<Reporte> lista) throws Exception{
        for(Reporte reporte: lista){
            pacienteEjb.removerReporte(reporte);
        }

    }
    
    @GET
    public List<Paciente> darPacientes(){
        
        return pacienteEjb.darPacientes();
    }
    
    @GET
    @Path("reportes/")
    public List<Reporte> darReportes(){
        return pacienteEjb.getReportes();
    }
           
    
    @GET
    @Path("/reporte/{idReporte}") //Ejemplo de este metodo: http://localhost:8080/hospitalKennedy.servicios/webresources/Pacientes/reporte/123456
    public Reporte getReporte(@PathParam("idReporte") long idReporte){
        System.out.println("Entroooooooooo y cogio el id de "+ idReporte);
        List reportes = pacienteEjb.getReportes();
        Iterator<Reporte> it = reportes.iterator();
        while(it.hasNext()){
            Reporte reporteAct = it.next();
            if(reporteAct.getId()== idReporte)
            {
             } else {
               return reporteAct;
            }
        }
        return null;
    }
}
