package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    List<Categoria> listar();
    void guardar(Categoria categoria);
    Categoria buscar(Long idCategoria);
    void eliminar(Long idCategoria);
}
