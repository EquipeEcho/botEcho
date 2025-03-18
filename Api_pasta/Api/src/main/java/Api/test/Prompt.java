/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Api.test;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import io.github.ollama4j.utils.PromptBuilder;
import java.sql.Connection;

/**
 *
 * @author Ryan
 */
public class Prompt {
        private char ia;
    private Connection conn;
    private String host = "http://localhost:11434/",resposta, respostaBot;
    private OllamaAPI ollamaAPI = new OllamaAPI(host);
    

    
    public void getResposta(String resposta){
        this.resposta = resposta;
    }
    
    public void novoAddLine() {
        
    }
    
    public void Analise(String resposta) throws Exception{
        ConnectionDB.connectDB();
            ollamaAPI.setRequestTimeoutSeconds(120);
        PromptBuilder promptBuilder =
                new PromptBuilder()
                        .addLine("Você interpreta código na linguagem Python e devolve APENAS o resultado deles")
                        .addSeparator()
                        .addLine(resposta)
                        .addSeparator()
                        .add("Devolva o resultado do código ou o erro encontrado");
                        
        
        boolean raw = false;
        OllamaResult response = ollamaAPI.generate("qwen2.5-coder:7b", promptBuilder.build(), raw, new OptionsBuilder().build());
        
        this.respostaBot = response.getResponse();
    }
    
    public void Explicacao(String resposta) throws Exception {
        ConnectionDB.connectDB();
        ollamaAPI.setRequestTimeoutSeconds(120);
        PromptBuilder promptBuilder =
                new PromptBuilder()
                        .addLine("Você interpreta código na linguagem Python e devolve APENAS o resultado deles")
                        .addSeparator()
                        .add("Devolva o resultado do código ou o erro encontrado");
                        
        
        boolean raw = false;
        OllamaResult response = ollamaAPI.generate("qwen2.5-coder:7b", promptBuilder.build(), raw, new OptionsBuilder().build());
        
        this.respostaBot = response.getResponse();
    }
    
    public void Sugestao(String resposta) throws Exception {
        ConnectionDB.connectDB();
        ollamaAPI.setRequestTimeoutSeconds(120);
        PromptBuilder promptBuilder =
                new PromptBuilder()
                        .addLine("Você interpreta código na linguagem Python e devolve APENAS o resultado deles")
                        .addSeparator()
                        .add("Devolva o resultado do código ou o erro encontrado");
                        
        
        boolean raw = false;
        OllamaResult response = ollamaAPI.generate("qwen2.5-coder:7b", promptBuilder.build(), raw, new OptionsBuilder().build());
        
        this.respostaBot = response.getResponse();
    }
    public String respostaBot (){
    return this.respostaBot;
    }
}
