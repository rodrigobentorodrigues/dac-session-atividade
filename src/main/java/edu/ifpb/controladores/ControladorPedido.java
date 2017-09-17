package edu.ifpb.controladores;

import edu.ifpb.entidades.Pedido;
import edu.ifpb.entidades.Produto;
import edu.ifpb.interfaces.Dao;
import edu.ifpb.interfaces.Servico;
import java.io.Serializable;
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
    private List<Produto> todosProdutos = new ArrayList<>();
    private List<Produto> auxiliar = new ArrayList<>();
    private List<Produto> vitrine = new ArrayList<>();
    private List<Produto> produtosPedido = new ArrayList<>();

    public String addProduto(Produto p) {
        produtosPedido.add(p);
        boolean cond = false;
        for(Produto aux: auxiliar){
            if(aux.equals(p)){
                cond = true;
            }
        }
        if(!cond){
            auxiliar.add(p);
        }
        return null;
    }

    public String removerProduto(Produto p) {
        produtosPedido.remove(p);
        auxiliar.remove(p);
        return null;
    }

    public String confirmarPedido() {
        Pedido pedido = new Pedido();
        pedido.setProdutos(auxiliar);
        dao.addPedido(pedido);
        produtosPedido = new ArrayList<>();
        auxiliar = new ArrayList<>();
        return null;
    }

    public String cancelarPedido() {
        produtosPedido = new ArrayList<>();
        return null;
    }

    public List<Produto> getTodosProdutos() {
        return servico.listarTodos();
    }

    public void setTodosProdutos(List<Produto> todosProdutos) {
        this.todosProdutos = todosProdutos;
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
