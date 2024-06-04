/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.trabalho.juliane.paulinho.desk;

import dto.ClienteDTO;
import java.util.List;
import service.ClientesService;

/**
 *
 * @author aluno
 */
public class TrabalhoJulianePaulinhoDesk {

    public static void main(String[] args) {

        new HomeFrame().setVisible(true);
        try {
            List<ClienteDTO> cli
                    = ClientesService.buscaCliente();

            System.out.println(cli.toString());
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
