package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    List<Articulo> listarArticulos();
    void guardar(Articulo articulo);
    Articulo encontrarArticulo(Long idArticulo);
    void eliminar(Long idArticulo);
}
