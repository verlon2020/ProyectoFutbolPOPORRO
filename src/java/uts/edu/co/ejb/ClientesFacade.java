/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.co.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uts.edu.co.entidades.Clientes;

/**
 *
 * @author josue
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "Proyecto3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }
    
    public Clientes buscarCliente(String cedula){
        em.flush();
        return em.find(Clientes.class, cedula);
    }
    
    public void borrarCliente(String cedula){
        em.remove(buscarCliente(cedula));
        em.flush();
    }

    public List morosos(){
        Query query = em.createQuery("SELECT c FROM Clientes c WHERE c.mesesMora > 0");
        
        if(query.getResultList().size() > 0){
            List orden = query.getResultList();
            return orden;
        }
        return null;
    }
    
    public int numeroMorosos(){
        Query query = em.createQuery("SELECT c FROM Clientes c WHERE c.mesesMora > 0");
        
        if(query.getResultList().size() > 0){
            return query.getResultList().size();
        }
        return 0;
    }
    
    public List paraCorte(){
        Query query = em.createQuery("SELECT c FROM Clientes c WHERE c.mesesMora >= 2");
        
        if(query.getResultList().size() > 0){
            List orden = query.getResultList();
            return orden;
        }
        return null;
    }
    
    public int numeroCorte(){
        Query query = em.createQuery("SELECT c FROM Clientes c WHERE c.mesesMora >= 2");
        
        if(query.getResultList().size() > 0){
            return query.getResultList().size();
        }
        return 0;
    }
}
