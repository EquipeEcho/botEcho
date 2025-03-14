/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Api.test;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.types.OllamaModelType;
import io.github.ollama4j.utils.OptionsBuilder;
import io.github.ollama4j.utils.PromptBuilder;
import java.io.IOException;
import java.sql.Connection;

/**
 *
 * @author Ryan
 */
public class Api {

    public static void main(String[] args) throws Exception  {
        String host = "http://localhost:11434/";
        OllamaAPI ollamaAPI = new OllamaAPI(host);
        ollamaAPI.setRequestTimeoutSeconds(120);
        
      Connection conn = ConnectionDB.connectDB();
      
        PromptBuilder promptBuilder =
                new PromptBuilder()
                        .addLine("Voce é um analista de qualidade")
                        .addSeparator()
                        .addLine("Esta ensinando uma equipe sobre testes de código")
                        .addSeparator()
                        .addLine("O primeiro topico é Unit Tests")
                        .addSeparator()
                        .add("Escreva um resumo de Unit Tests");
        
        boolean raw = false;
        OllamaResult response = ollamaAPI.generate("qwen2.5-coder:7b", promptBuilder.build(), raw, new OptionsBuilder().build());
        System.out.println(response.getResponse());
        
        ConnectionDB.insertDB(conn, response.getResponse(), true);
        
        System.out.println("Dados INSERIDOS");
    }
}
