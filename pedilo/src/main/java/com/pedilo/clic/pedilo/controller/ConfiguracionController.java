package com.pedilo.clic.pedilo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pedilo.clic.pedilo.modelo.Configuracion;
import com.pedilo.clic.pedilo.modelo.Producto;
import com.pedilo.clic.pedilo.service.ConfiguracionService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/configuracion")
public class ConfiguracionController {

    @Autowired
    private ConfiguracionService configuracionService;

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        Map<String,Object> model = new HashMap<String, Object>();
        return new ModelAndView("abmConfiguracion","model",model);
    }

    @RequestMapping(value = "/get")
    protected @ResponseBody Configuracion get(){
        Configuracion configuracion = configuracionService.findAll() != null && configuracionService.findAll().size() > 0 ?configuracionService.findAll().get(0):null;
        return configuracion;
    }

    @RequestMapping(value = {"/create","/edit"},produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    protected @ResponseBody Map<String,Object> create(@RequestBody Configuracion configuracion, HttpServletRequest request) throws JsonProcessingException {
        Map<String,Object> model = new HashMap<String, Object>();
        configuracionService.save(configuracion);

        model.put("status","ok");
        return model;
    }
}
