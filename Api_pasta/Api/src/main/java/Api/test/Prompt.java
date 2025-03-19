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
import javax.swing.JOptionPane;

/**
 *
 * @author Ryan
 */
public class Prompt {
    private char ia;
    private Boolean util;
    private Connection conn;
    private String host = "http://localhost:11434/",resposta, respostaBot, u;
    private OllamaAPI ollamaAPI = new OllamaAPI(host);
    
    public void getResposta(String resposta){
        this.resposta = resposta;
    }
    
    public String Analise(String resposta) throws Exception{
        ollamaAPI.setRequestTimeoutSeconds(120);
        
        PromptBuilder promptBuilder =
                new PromptBuilder()
                        .addLine("voce é um desenvolvedor especialista em python e possui conhcimento abrangente para detectar erros")
                        .addSeparator()
                        .addLine("analise codigos na liguagem python para ver se esta escrito corretamente")
                        .addSeparator()  
                        .addLine("corrija os erros que houver de sintaxe em python")
                        .addSeparator()
                        .addLine("analise e explique se houver algum erro lógico no codigo")
                        .addSeparator()
                        .addLine("analise o codigo para verificar se esta bem identado, corrija a identação")
                        .addSeparator()     
                        .addLine("verificar se não há o erro NameError")
                        .addSeparator()  
                        .addLine("verifique se todas as chaves passadas tem um dicionario existente, aponte se houver KeyError")
                        .addSeparator()                           
                        .addLine(resposta)
                        .addSeparator()
                        .add("devolva a analise do codigo e diga quais sao os erros existentes ou se não há erros, logo após devolva o codigo corrigido");
                        
        boolean raw = false;
        OllamaResult response = ollamaAPI.generate("qwen2.5-coder:7b", promptBuilder.build(), raw, new OptionsBuilder().build());
        
        return this.respostaBot = response.getResponse();
    }
    
    public void Explicacao(String resposta) throws Exception {
        ConnectionDB.connectDB();
        ollamaAPI.setRequestTimeoutSeconds(120);
        PromptBuilder promptBuilder =
                new PromptBuilder()
                        .addLine("Você é uma IA especialista em Python")
                        .addSeparator()
                        .addLine("capaz de analisar e explicar códigos de forma clara e precisa")
                        .addSeparator( )
                        .addLine("sempre que receber um código como entrada, siga estas diretrizes:")
                        .addSeparator()
                        .addLine("Explique o que o código faz de maneira objetiva e detalhada.")
                        .addSeparator()
                        .addLine("Comente o funcionamento de cada parte do código, incluindo estruturas de controle, funções, classes e bibliotecas usadas.")
                        .addSeparator()
                        .addLine("Forneça exemplos ou analogias, se necessário, para facilitar a compreensão.")
                        .addSeparator()
                        .addLine("Adapte sua explicação para diferentes níveis de conhecimento, desde iniciantes até programadores experientes.\"")
                        .addSeparator()
                        .add(resposta);
                        
                        
        
        boolean raw = false;
        OllamaResult response = ollamaAPI.generate("qwen2.5-coder:7b", promptBuilder.build(), raw, new OptionsBuilder().build());
        
        
        this.respostaBot = response.getResponse();
    }
    
    public void Sugestao(String resposta) throws Exception {
        ConnectionDB.connectDB();
        ollamaAPI.setRequestTimeoutSeconds(120);
        PromptBuilder promptBuilder =
                new PromptBuilder()
                        .addLine(resposta)
                        .addSeparator()
                        .add("Devolva Sugestões e exemplos de como melhorar o código");
     
        boolean raw = false;
        OllamaResult response = ollamaAPI.generate("qwen2.5-coder:7b", promptBuilder.build(), raw, new OptionsBuilder().build());
        
        this.respostaBot = response.getResponse();
    }
    public void Pergunte(String resposta) throws Exception {
        ConnectionDB.connectDB();
        ollamaAPI.setRequestTimeoutSeconds(400);
        PromptBuilder promptBuilder = new PromptBuilder().addLine(resposta).addSeparator().add("Analize a pergunta e apenas responda e utilize exemplos");
                    
        boolean raw = false;
        OllamaResult response = ollamaAPI.generate("qwen2.5-coder:7b", promptBuilder.build(), raw, new OptionsBuilder().build());
        
        this.respostaBot = response.getResponse();
    }
    public String respostaBot (){
    return this.respostaBot;
    }
    
    public Boolean Utilidade() throws Exception{
        String[] opcoes = {"Sim", "Não"};
        int u = JOptionPane.showOptionDialog(null, "Essa resposta foi útil para você?", "Feedback", JOptionPane.DEFAULT_OPTION,  JOptionPane.QUESTION_MESSAGE, null, opcoes, 1);
        if (u == 1) {
            Boolean ut = (u != 0);
            
            return ut;
        } else {
            Boolean ut = (u != 1);
            
            return ut;
        }
    }
}
