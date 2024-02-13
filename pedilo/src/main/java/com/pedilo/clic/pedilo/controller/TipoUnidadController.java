package com.pedilo.clic.pedilo.controller;

import com.pedilo.clic.pedilo.modelo.TipoUnidad;
import com.pedilo.clic.pedilo.service.TipoUnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tipoUnidad")
public class TipoUnidadController {

    @Autowired
    private TipoUnidadService tipoUnidadService;


    @RequestMapping(value = "/{id}")
    public @ResponseBody TipoUnidad get(@PathVariable Long id){
        TipoUnidad tipoUnidad = tipoUnidadService.getById(id);
        return tipoUnidad;
    }
    @RequestMapping(value = "/list")
    public @ResponseBody List<TipoUnidad> list(){

        return tipoUnidadService.findAll();
    }
}
