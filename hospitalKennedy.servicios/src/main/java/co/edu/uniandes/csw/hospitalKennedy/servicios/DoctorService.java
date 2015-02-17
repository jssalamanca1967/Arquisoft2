/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.hospitalKennedy.servicios;

import co.edu.uniandes.csw.hospitalKennedy.dto.Paciente;
import co.edu.uniandes.csw.hospitalKennedy.dto.Reporte;
import co.edu.uniandes.csw.hospitalKennedy.logica.interfaces.IServicioDoctorMock;
import java.util.ArrayList;
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
@Path("/Doctor")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DoctorService {
    
    @EJB
    private IServicioDoctorMock doctorEjb;
    
    @POST
    @Path("agregar/")
    public List<Paciente> agregarPacientes(List<Paciente> lista){
        for(Paciente paciente: lista){
            doctorEjb.agregarPaciente(paciente);
        }
        
        return lista;
    }
    
    @DELETE
    @Path("borrar/")
    public void eliminarPacientes(List<Paciente> lista){
        for(Paciente paciente: lista){
            doctorEjb.removerPaciente(paciente);
        }
    }
    
    @GET
    @Path("paciente/{idPaciente}")
    public Paciente darPaciente(@PathParam("idPaciente") long idPaciente){
        ArrayList<Paciente> pacientes = doctorEjb.getPacientes();
        Paciente pacienteAct = null;
        for(int i =0; i < pacientes.size();i++){
            pacienteAct = pacientes.get(i);
            if(pacienteAct.getId() == idPaciente){
                i = pacientes.size();
            }
        }
        return pacienteAct;
                
    }
}
