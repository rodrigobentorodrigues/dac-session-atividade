
package edu.ifpb.infra;

import edu.ifpb.entidades.Pedido;
import edu.ifpb.interfaces.Dao;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local(Dao.class)
public class DaoImpl implements Dao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void add(Pedido p) {
        em.persist(p);
    }
    
}
