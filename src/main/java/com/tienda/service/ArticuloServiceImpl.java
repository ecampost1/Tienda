package com.tienda.service;

import com.tienda.Repository.ArticuloRepository;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Articulo> listarArticulos() {
        return (List<Articulo>) articuloRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Articulo articulo) {
        articuloRepository.save(articulo);
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo encontrarArticulo(Long idArticulo) {
        return articuloRepository.findById(idArticulo).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long idArticulo) {
        articuloRepository.deleteById(idArticulo);
    }
}
