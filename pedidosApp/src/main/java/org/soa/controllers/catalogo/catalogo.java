package org.soa.controllers.catalogo;

import org.soa.models.Producto;
import org.soa.models.Usuario;
import org.soa.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class catalogo {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/catalogo")
    public String showCatalogo(Model model) {
        return "catalogo"; // Nombre de la vista catalogo.html
    }

    @GetMapping("/api/productos")
    @ResponseBody
    public List<Producto> getProductos() {
        return productoService.obtenerTodosLosProductos(); // Devuelve la lista de productos
    }

    @GetMapping("/api/user")
    @ResponseBody
    public Usuario getUsuario(@SessionAttribute(name = "usuarioActivo", required = false) Usuario usuario) {
        return usuario; // Retorna el objeto Usuario directamente si está en la sesión
    }
}
