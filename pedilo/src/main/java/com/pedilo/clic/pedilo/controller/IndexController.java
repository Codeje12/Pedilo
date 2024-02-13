package com.pedilo.clic.pedilo.controller;

import com.pedilo.clic.pedilo.modelo.Configuracion;
import com.pedilo.clic.pedilo.modelo.Producto;
import com.pedilo.clic.pedilo.modelo.TipoUnidad;
import com.pedilo.clic.pedilo.modelo.UsuarioVendedor;
import com.pedilo.clic.pedilo.service.ConfiguracionService;
import com.pedilo.clic.pedilo.service.ProductoService;
import com.pedilo.clic.pedilo.service.UsuarioVendedorService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Controller
public class IndexController {

    @Autowired
    private ConfiguracionService configuracionService;
    @Autowired
    private UsuarioVendedorService usuarioVendedorService;
    @Autowired
    private ProductoService productoService;

    @RequestMapping(value="/index")
    public ModelAndView index(HttpServletRequest request){
        Map<String,Object>model = new HashMap<String, Object>();

        ServletContext context = request.getServletContext();
        String pathHelper = context.getRealPath("/WEB-INF/img/producto").toString();

        model.put("ruta",pathHelper.replace("\\", "/"));

        return new ModelAndView("index","model",model);
    }
}
