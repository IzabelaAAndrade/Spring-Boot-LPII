package com.eventosapp.controllers;

import com.eventosapp.models.Evento;
import com.eventosapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @RequestMapping(value="/cadastrarEvento", method= RequestMethod.GET)
    public String form(){
        return "eventos/formEvento";
    }

    @RequestMapping(value="/cadastrarEvento", method= RequestMethod.POST)
    public String form(Evento e){
        er.save(e);

        return "redirect:cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listarEventos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento> eventosCadastrados = er.findAll();
        mv.addObject("evento", eventosCadastrados);

        return mv;
    }

}
