/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.trabalho.juliane.paulinho.desk.Util;
import dto.ItemVendaDTO;
import dto.VendaDTO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author User
 */
public class ItemVendaService {

    private static String URLWEBSERVICE = "http://localhost:8080/api/itemVenda";
    private static int SUCESSO = 200;

    public static ItemVendaDTO salvarItemVenda(ItemVendaDTO itemVenda) throws Exception {
        String urlChamada = URLWEBSERVICE;
        HttpURLConnection conexao = null;

        try {
            URL url = new URL(urlChamada);
            conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("POST");
            conexao.setRequestProperty("Content-Type", "application/json");
            conexao.setDoOutput(true);

            ObjectMapper mapper = new ObjectMapper();
            String body = mapper.writeValueAsString(itemVenda);

            try (OutputStream os = conexao.getOutputStream()) {
                byte[] input = body.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            if (conexao.getResponseCode() != SUCESSO) {
                throw new RuntimeException(
                        "Erro ao conectar: " + conexao.getResponseMessage());
            }

            BufferedReader resposta = new BufferedReader(
                    new InputStreamReader(conexao.getInputStream()));
            String json = Util.converteJsonString(resposta);

            ItemVendaDTO dto = unmarshalFromJson(json);
            return dto;
        } catch (Exception ex) {
            throw new Exception("Erro ao retornar produto: " + ex);
        } finally {
            if (conexao != null) {
                conexao.disconnect(); 
            }
        }
    }

    private static ItemVendaDTO unmarshalFromJson(String json)
            throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ItemVendaDTO itemVendaDTO = mapper.readValue(json, new TypeReference<ItemVendaDTO>() {
        });
        return itemVendaDTO;
    }
}
