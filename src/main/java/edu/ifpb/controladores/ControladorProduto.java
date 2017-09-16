
package edu.ifpb.controladores;

import edu.ifpb.entidades.Produto;
import edu.ifpb.interfaces.Servico;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ControladorProduto {
    
    @EJB
    private Servico servico;
    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<>();
    private List<Produto> vitrine = new ArrayList<>();
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
    
    public String adicionarProduto(){
        servico.adicionar(produto);
        System.out.println(produto.toString());
        produto = new Produto();
        return null;
    }
    
}
