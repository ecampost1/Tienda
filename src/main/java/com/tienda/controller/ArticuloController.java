package com.tienda.controller;

import com.tienda.domain.Articulo;
import com.tienda.domain.Categoria;
import com.tienda.service.ArticuloService;
import com.tienda.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloService articuloService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarArticulos(Model model) {
        model.addAttribute("articulos", articuloService.listarArticulos());
        return "articulo_listado";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoArticulo(Model model) {
        model.addAttribute("articulo", new Articulo());
        model.addAttribute("categorias", categoriaService.listar());
        return "articulo_form";
    }

    @PostMapping("/guardar")
    public String guardarArticulo(@ModelAttribute Articulo articulo) {
        articuloService.guardar(articulo);
        return "redirect:/articulos";
    }

    @GetMapping("/editar/{id}")
    public String editarArticulo(@PathVariable("id") Long idArticulo, Model model) {
        model.addAttribute("articulo", articuloService.encontrarArticulo(idArticulo));
        model.addAttribute("categorias", categoriaService.listar());
        return "articulo_form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarArticulo(@PathVariable("id") Long idArticulo) {
        articuloService.eliminar(idArticulo);
        return "redirect:/articulos";
    }
}
