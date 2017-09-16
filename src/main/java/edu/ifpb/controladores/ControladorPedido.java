package edu.ifpb.controladores;

import edu.ifpb.entidades.Pedido;
import edu.ifpb.entidades.Produto;
import edu.ifpb.interfaces.Dao;
import edu.ifpb.interfaces.Servico;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ControladorPedido implements Serializable {
    
    @EJB
    private Dao dao;
    @EJB
    private Servico servico;
    private List<Produto> produtos = new ArrayList<>();
    private List<Produto> vitrine = new ArrayList<>();
    private List<Produto> produtosPedido = new ArrayList<>();
    
    public void salvar() {
        Pedido p = new Pedido();
        p.add(new Produto("Teste", BigDecimal.valueOf(999)));
        dao.add(p);
        System.out.println("Adicionado no BD");
    }
    
    public String addProduto(Produto p){
        produtosPedido.add(p);
        System.out.println(produtosPedido.toString());
        return null;
    }
    
    public String confirmarPedido(){
        // Implementar
        return null;
    }
    
    public String cancelarPedido(){
        // Implementar
        return null;
    }
    
    public List<Produto> getProdutos() {
        return servico.listarTodos();
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getVitrine() {
        return servico.listarVitrine();
    }

    public void setVitrine(List<Produto> vitrine) {
        this.vitrine = vitrine;
    }

    public List<Produto> getProdutosPedido() {
        return produtosPedido;
    }

    public void setProdutosPedido(List<Produto> produtosPedido) {
        this.produtosPedido = produtosPedido;
    }    

}
