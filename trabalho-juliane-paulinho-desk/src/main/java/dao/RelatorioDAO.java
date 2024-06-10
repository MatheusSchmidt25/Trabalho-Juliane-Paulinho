/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexaoBD.ConexaoPostgres;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author MatheusFernandodosSa
 */
public class RelatorioDAO {

    public Connection conn = null;

    public RelatorioDAO() {
        conn = ConexaoPostgres.getConection();
    }

    public void gerarRelatorio() {
        try {

            //Responsável em criar/carregar o relatório
            String relatorioPath = "relatorios/relatorioDetalhado.jasper";
            JasperPrint printer = JasperFillManager.
                    fillReport(relatorioPath,
                            null, conn);

            //Exibir o relatório
            JasperViewer view
                    = new JasperViewer(printer, false);

            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
        public void gerarRelatorio2() {
        try {
            //Responsável em criar/carregar o relatório
            String relatorioPath = "relatorios/Blank_A4.jasper";
            JasperPrint printer = JasperFillManager.
                    fillReport(relatorioPath,
                            null, conn);

            //Exibir o relatório
            JasperViewer view
                    = new JasperViewer(printer, false);

            view.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(RelatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
