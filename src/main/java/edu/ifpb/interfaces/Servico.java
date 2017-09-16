
package edu.ifpb.interfaces;

import java.util.List;

public interface Servico <T> {
    
    boolean adicionar(T t);
    List<T> listarTodos();
    List<T> listarVitrine();
    
}
