package br.unipar.programacaoweb.trabalhojulianepaulinho.controller;

import br.unipar.programacaoweb.trabalhojulianepaulinho.model.Venda;
import br.unipar.programacaoweb.trabalhojulianepaulinho.service.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Tag(name = "Gerenciamento de Vendas", description = "API para gerenciamento de vendas no sistema web")
public class VendaWebController {

    private final VendaService vendaService;

    public VendaWebController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @Operation(summary = "Obter todas as vendas", description = "Retorna uma lista de todas as vendas")
    @GetMapping(path = "/venda")
    public String getAllVenda(Model model) {
        List<Venda> venda = vendaService.getAll();
        model.addAttribute("venda", venda);
        return "venda";
    }

    @Operation(summary = "Salvar uma venda", description = "Salva uma nova venda no banco de dados")
    @PostMapping(path = "/venda/save")
    public String saveVenda(@Parameter(description = "Objeto venda que será armazenado no banco de dados", required = true) Venda venda) {
        vendaService.save(venda);
        return "redirect:/venda";
    }

    @Operation(summary = "Filtrar vendas por data", description = "Filtra as vendas com base na data fornecida")
    @PostMapping(path = "/venda/filtrar")
    public String filtrarVendas(@Parameter(description = "Data das vendas a serem filtradas no formato 'yyyy-MM-dd'", required = true)
                                @RequestParam("data") String data, Model model) {
        List<Venda> vendaFiltradas = vendaService.findByData(data);
        model.addAttribute("venda", vendaFiltradas);
        return "venda";
    }
}
