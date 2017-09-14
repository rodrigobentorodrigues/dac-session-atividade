package edu.ifpb.controladores;

import edu.ifpb.entidades.Pedido;
import edu.ifpb.entidades.Produto;
import edu.ifpb.interfaces.Dao;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ControladorPedido implements Serializable {
    
    @EJB
    private Dao dao;
    
    public void salvar() {
        Pedido p = new Pedido();
        p.add(new Produto("Teste", BigDecimal.valueOf(999)));
        dao.add(p);
        System.out.println("Adicionado no BD");
    }

}
