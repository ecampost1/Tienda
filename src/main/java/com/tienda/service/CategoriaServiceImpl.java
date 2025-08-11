package com.tienda.service;

import com.tienda.Repository.CategoriaRepository;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> listar() {
        return (List<Categoria>) categoriaRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria buscar(Long idCategoria) {
        return categoriaRepository.findById(idCategoria).orElse(null);
    }

    @Override
    @Transactional
    public void eliminar(Long idCategoria) {
        categoriaRepository.deleteById(idCategoria);
    }
}
