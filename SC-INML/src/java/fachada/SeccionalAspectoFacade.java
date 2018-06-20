/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.SeccionalAspecto;

/**
 *
 * @author julia
 */
@Stateless
public class SeccionalAspectoFacade extends AbstractFacade<SeccionalAspecto> {

    @PersistenceContext(unitName = "SC-INMLPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeccionalAspectoFacade() {
        super(SeccionalAspecto.class);
    }
    
}
