/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.hospitalKennedy.logica.ejb;

import co.edu.uniandes.csw.hospitalKennedy.dto.Reporte;
import co.edu.uniandes.csw.hospitalKennedy.logica.interfaces.IServicioPacienteMock;
import co.edu.uniandes.csw.hospitalKennedy.logica.interfaces.IServicioPersistenciaMockLocal;
import co.edu.uniandes.csw.hospitalKennedy.persistencia.mock.ServicioPersistenciaMock;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author estudiante
 */
@Stateless
public class ServicioPacienteMock implements IServicioPacienteMock {
    
    private IServicioPersistenciaMockLocal persistencia;
    private ArrayList<Reporte> reportes;

    public ServicioPacienteMock()
    {
        reportes = new ArrayList<Reporte>();
        persistencia=new ServicioPersistenciaMock();
    }

    @Override
    public void setPacientes(ArrayList<Reporte> reportes) {
        this.reportes = reportes;
    }


    @Override
    public ArrayList<Reporte> getPacientes() {
        return reportes;
    }
    
             
    @Override
    public void agregarReporte(Reporte reporte){
    
        boolean found = false;
        Reporte item;
        for(int i= 0, max= reportes.size(); i < max; i++)
        {
            item = (Reporte)reportes.get(i);
            if (item.getNumeroIdentificacion()== reporte.getNumeroIdentificacion())
            {
                found = true;
                break;
            }
        }

        if (!found)
        {
            reportes.add(reporte);
        }

    }
    
    /**
     * Remueve un mueble del carrito de compra
     * @param mueble Mueble a remover
     * @param removerCero Indica si al ser cero se elimina de la lista
     */
    @Override
    public void removerReporte(Reporte reporte)
    {

        Reporte foundItem = null;
        Reporte item;
        for(int i= 0, max= reportes.size(); i < max; i++)
        {
            item = (Reporte)reportes.get(i);
            if (item.getNumeroIdentificacion()== reporte.getNumeroIdentificacion())
            {
                foundItem = item;
                break;
            }
        }

        // Remueve el item si la cantidad es menor o igual a cero
        if (foundItem != null) {
            reportes.remove(foundItem);
        }
    }
    
}
