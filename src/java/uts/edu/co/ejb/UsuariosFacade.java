/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.edu.co.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import uts.edu.co.entidades.Usuarios;

/**
 *
 * @author josue
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "Proyecto3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Usuarios findByCorreo(String correo) {
        TypedQuery<Usuarios> query = em.createQuery("SELECT u FROM Usuarios u WHERE u.correo = :correo", Usuarios.class);
        query.setParameter("correo", correo);

        List<Usuarios> resultado = query.getResultList();
        return resultado.isEmpty() ? null : resultado.get(0);
    }
}
