package com.eventosapp.controllers;

import com.eventosapp.models.Convidado;
import com.eventosapp.models.Evento;
import com.eventosapp.repository.ConvidadoRepository;
import com.eventosapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EventoController {

    @Autowired
    private EventoRepository er;

    @Autowired
    private ConvidadoRepository cr;

    @RequestMapping(value="/cadastrarEvento", method= RequestMethod.GET)
    public String form(){
        return "eventos/formEvento";
    }

    @RequestMapping(value="/cadastrarEvento", method= RequestMethod.POST)
    public String form(@Valid Evento e, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Houve um erro no cadastro. Verifique os Campos!");
            return "redirect:cadastrarEvento";
        }
        er.save(e);
        attributes.addFlashAttribute("mensagem", "Evento cadastrado com sucesso :)");
        return "redirect:cadastrarEvento";
    }

    @RequestMapping("/eventos")
    public ModelAndView listarEventos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento> eventosCadastrados = er.findAll();
        mv.addObject("evento", eventosCadastrados);

        return mv;
    }
    @RequestMapping(value="/{codigo}", method=RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
        ModelAndView mv = new ModelAndView("eventos/detalhesEvento");
        Evento evento = er.findByCodigo(codigo);
        Iterable<Convidado> convidados = cr.findByEvento(evento);

        mv.addObject("evento", evento);
        mv.addObject("convidados", convidados);
        return mv;
    }

    @RequestMapping(value="/{codigo}", method=RequestMethod.POST)
    public String detalhesEventoPost(@PathVariable("codigo") long codigo, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes){
        Evento evento = er.findByCodigo(codigo);
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Houve um erro no cadastro. Verifique os Campos!");
            return "redirect:/{codigo}";
        }
        convidado.setEvento(evento);
        cr.save(convidado);
        attributes.addFlashAttribute("mensagem", "Convidado cadastrado com sucesso :)");
        return "redirect:/{codigo}";
    }

}
