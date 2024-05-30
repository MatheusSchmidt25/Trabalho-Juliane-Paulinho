package br.unipar.programacaoweb.trabalhojulianepaulinho.controller;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Venda;
import br.unipar.programacaoweb.trabalhojulianepaulinho.service.VendaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class VendaWebController {

    private final VendaService vendaService;

    public VendaWebController(VendaService vendaService) {
        this.vendaService = vendaService;
    }


    @GetMapping(path = "/venda")
    public String getAllVenda(Model model) {
        List<Venda> venda = vendaService.getAll();
        model.addAttribute("venda", venda);
        return "venda";
    }


    @PostMapping(path = "/venda/save")
    public String saveVenda(Venda venda) {
        vendaService.save(venda);
        return "redirect:/venda";
    }

}
