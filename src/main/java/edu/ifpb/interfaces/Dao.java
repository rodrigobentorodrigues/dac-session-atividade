
package edu.ifpb.interfaces;

import edu.ifpb.entidades.Pedido;
import edu.ifpb.entidades.Produto;

public interface Dao {

    void addPedido(Pedido p);
    void addProduto(Produto p);
    
}
