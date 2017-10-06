
package edu.ifpb.infra;

import edu.ifpb.entidades.Pedido;
import edu.ifpb.entidades.Produto;
import edu.ifpb.interfaces.Dao;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Local(Dao.class)
public class DaoImpl implements Dao{

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addPedido(Pedido p) {
        em.persist(p);
    }
    
    @Override
    public void addProduto(Produto p) {
        em.persist(p);
    }
    
}
