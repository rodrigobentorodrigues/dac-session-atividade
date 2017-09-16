package edu.ifpb.infra;

import edu.ifpb.entidades.Produto;
import edu.ifpb.interfaces.Servico;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Local;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@Local(Servico.class)
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class ServicoProduto implements Servico<Produto> {

    private List<Produto> produtos = new CopyOnWriteArrayList<>();

    @Lock(LockType.WRITE)
    @Override
    public boolean adicionar(Produto t) {
        return produtos.add(t);
    }

    @Lock(LockType.READ)
    @Override
    public List<Produto> listarTodos() {
        return Collections.unmodifiableList(produtos);
    }

    @Override
    public List<Produto> listarVitrine() {
        if (produtos.size() > 3) {
            return Collections.unmodifiableList(produtos.subList(produtos.size() - 3, produtos.size()));
        } else {
            return Collections.unmodifiableList(produtos);
        }
    }
}
