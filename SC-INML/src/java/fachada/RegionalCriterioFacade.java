/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.RegionalCriterio;

/**
 *
 * @author julia
 */
@Stateless
public class RegionalCriterioFacade extends AbstractFacade<RegionalCriterio> {

    @PersistenceContext(unitName = "SC-INMLPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegionalCriterioFacade() {
        super(RegionalCriterio.class);
    }
    
}