/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.co.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uts.edu.co.entidades.Servicio;

/**
 *
 * @author josue
 */
@Stateless
public class ServicioFacade extends AbstractFacade<Servicio> {

    @PersistenceContext(unitName = "Proyecto3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicioFacade() {
        super(Servicio.class);
    }
    
    public Servicio buscarServicio(int id){
        em.flush();
        return em.find(Servicio.class, id);
    }
}
