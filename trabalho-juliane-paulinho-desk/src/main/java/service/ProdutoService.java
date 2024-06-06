/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ProdutoDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import com.mycompany.trabalho.juliane.paulinho.desk.Util;

/**
 *
 * @author aluno
 */
public class ProdutoService {

    private static String URLWEBSERVICE = "http://localhost:8080/api/produto";
    private static int SUCESSO = 200;

    public static List<ProdutoDTO> buscaProduto() throws Exception {
        String urlChamada = URLWEBSERVICE;

        try {
            URL url = new URL(urlChamada);
            HttpURLConnection conexao
                    = (HttpURLConnection) url.openConnection();

            if (conexao.getResponseCode() != SUCESSO) {
                throw new RuntimeException(
                        "Erro ao conectar: " + conexao.getResponseMessage());
            }
            BufferedReader resposta = new BufferedReader(
                    new InputStreamReader(conexao.getInputStream()));

            String json = Util.converteJsonString(resposta);
            List<ProdutoDTO> dto = unmarshalFromJson(json);
            return dto;

        } catch (Exception ex) {
            throw new Exception("Erro ao retornar produto: " + ex);
        }
    }

    private static List<ProdutoDTO> unmarshalFromJson(String json)
            throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<ProdutoDTO> produtoList = mapper.readValue(json, new TypeReference<List<ProdutoDTO>>() {
        });
        return produtoList;

    }

}
