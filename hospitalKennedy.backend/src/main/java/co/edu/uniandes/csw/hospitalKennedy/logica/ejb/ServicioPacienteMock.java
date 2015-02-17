/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.hospitalKennedy.logica.ejb;

import co.edu.uniandes.csw.hospitalKennedy.dto.Paciente;
import co.edu.uniandes.csw.hospitalKennedy.dto.Reporte;
import co.edu.uniandes.csw.hospitalKennedy.logica.interfaces.IServicioPacienteMock;
import co.edu.uniandes.csw.hospitalKennedy.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.hospitalKennedy.persistencia.mock.ServicioPersistenciaMock;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
@Stateful
public class ServicioPacienteMock implements IServicioPacienteMock {
    
    @EJB
    private IServicioPersistenciaMockLocal persistencia;
    

    public ServicioPacienteMock()
    {
        persistencia = new ServicioPersistenciaMock();
        
    }

    @Override
    public ArrayList<Reporte> getReportes(Long idPaciente) 
    {
        ArrayList<Reporte> rta = new ArrayList<Reporte>();
        
        try
        {
            rta = (ArrayList<Reporte>) persistencia.findReportes(idPaciente);
        }
        catch(Exception ex)
        {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);

        }
        return rta;
    }
    
             
    @Override
    public void agregarReporte(Long idPaciente, Reporte reporte){
    
        try
        {
            persistencia.createReporte(idPaciente, reporte);
        }
        catch(Exception ex)
        {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        

    }
    
    @Override
    public void removerReporte(Long idPaciente, Reporte reporte)
    {

        try
        {
            persistencia.deleteReporte(idPaciente, reporte);
        }
        catch(Exception ex)
        {
            Logger.getLogger(ServicioCatalogoMock.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }

    
    @Override
    public List<Paciente> darPacientes(){
        
        System.out.println("Eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeehhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
        return persistencia.findAll(Paciente.class);

    }  

    
}
