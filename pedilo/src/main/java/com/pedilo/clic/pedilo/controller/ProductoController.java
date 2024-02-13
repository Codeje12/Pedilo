package com.pedilo.clic.pedilo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pedilo.clic.pedilo.modelo.Producto;
import com.pedilo.clic.pedilo.modelo.TipoUnidad;
import com.pedilo.clic.pedilo.service.ProductoService;
import com.pedilo.clic.pedilo.service.TipoUnidadService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private TipoUnidadService tipoUnidadService;

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        Map<String,Object> model = new HashMap<String, Object>();

        List<TipoUnidad> tipoUnidades = tipoUnidadService.findAll();
        model.put("tipoUnidadList",tipoUnidades);
        model.put("action","list");

        return new ModelAndView("abmProducto","model",model);
    }

    @RequestMapping(value = "/nuevo")
    public ModelAndView nuevo(){
        Map<String,Object> model = new HashMap<String, Object>();

        model.put("action","create");
        return new ModelAndView("abmProducto","model",model);
    }

    @RequestMapping(value = "/{id}")
    public @ResponseBody Producto edit(@PathVariable Long id){
        Producto producto = productoService.getById(id);
        return producto;
    }

    @RequestMapping(value = {"/create","/edit"},produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    protected @ResponseBody Map<String,Object> create(@RequestBody Producto producto, HttpServletRequest request) throws JsonProcessingException {
        Map<String,Object> model = new HashMap<String, Object>();
        productoService.save(producto);

        model.put("status","ok");
        return model;
    }

    @RequestMapping(value = "/list")
    protected @ResponseBody List<Producto> list(){
        List<Producto> productos = productoService.findAll(Sort.by("id"));
        return productos;
    }

    @RequestMapping(value = "/activo", method = RequestMethod.POST)
    protected @ResponseBody Map<String,Object> activo(@RequestParam Long id){
        Map<String,Object> model = new HashMap<String, Object>();

        Producto producto = productoService.getById(id);
        Boolean activo = producto.getActivo() ? Boolean.FALSE:Boolean.TRUE;
        producto.setActivo(activo);

        productoService.save(producto);

        model.put("status", "ok");

        return null;
    }

    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam(name = "id")Long id,HttpServletRequest request)
            throws IOException {
        Map<String,Object> model = new HashMap<String, Object>();

        String status = "ok";
        String message = "Archivo cargado correctamente";

        if (file == null || file.isEmpty()) {
            status = "error";
            message = "Por favor seleccione un archivo";
        }

        ServletContext context = request.getServletContext();
/*        String pathHelper = context.getRealPath("/WEB-INF");
        File fileHelper = new File(context.getRealPath("/WEB-INF/img/producto"));

        if(!fileHelper.exists()){
            fileHelper.mkdirs();
        }

        if(!fileHelper.exists()){
            fileHelper.mkdirs();
        }

       // File fileOriginal = new File(path);
        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);

        StringBuilder builder = new StringBuilder();
        builder.append(pathHelper);
        builder.append(File.separator);
        builder.append("img"+File.separator+"producto");
        builder.append(File.separator);
        builder.append("producto_".concat(id.toString()).concat("."+extension));

        byte[] fileBytes = file.getBytes();
        Path path = Paths.get(builder.toString());
        Files.write(path, fileBytes);
        */

        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);

        StringBuilder builder = new StringBuilder();
        builder.append("src");
        builder.append(File.separator);
        builder.append("main");
        builder.append(File.separator);
        builder.append("resources");
        builder.append(File.separator);
        builder.append("static");
        builder.append(File.separator);
        builder.append("img"+File.separator+"producto");
        builder.append(File.separator);
        builder.append("producto_".concat(id.toString()).concat("."+extension));

        byte[] fileBytes = file.getBytes();
        Path path = Paths.get(builder.toString());
        Files.write(path, fileBytes);

        model.put("message",message);
        model.put("status",status);

        return model;
    }
}