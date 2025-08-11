package com.tienda.Repository;

import com.tienda.domain.Articulo;
import org.springframework.data.repository.CrudRepository;

public interface ArticuloRepository extends CrudRepository<Articulo, Long> {
}