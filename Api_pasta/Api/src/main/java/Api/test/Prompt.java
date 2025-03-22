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
                .addLine("Você é um desenvolvedor especialista em Python, com conhecimento abrangente para detectar erros.")
                .addSeparator()
                .addLine("Analise códigos na linguagem Python para verificar se estão escritos corretamente.")
                .addSeparator()
                .addLine("Corrija quaisquer erros de sintaxe encontrados.")
                .addSeparator()
                .addLine("Identifique e explique possíveis erros lógicos no código.")
                .addSeparator()
                .addLine("Verifique se o código está bem indentado e corrija a indentação, se necessário.")
                .addSeparator()
                .addLine("Verifique se não há erros do tipo NameError.")
                .addSeparator()
                .addLine("Certifique-se de que todas as chaves fornecidas possuem um dicionário correspondente e aponte possíveis KeyErrors.")
                .addSeparator()
                .addLine("Analise o código para identificar possíveis incoerências.")
                .addSeparator()
                .addLine(resposta)
                .addSeparator()
                .addLine("Retorne a análise do código, indicando os erros encontrados, se houver, e forneça uma versão corrigida.");
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
        ollamaAPI.setRequestTimeoutSeconds(360);
        PromptBuilder promptBuilder =
                new PromptBuilder()
                        .addLine("Interprete o seguinte código python:\n" + resposta)
                        .addSeparator()
                        .add("Devolva Sugestões e exemplos de como melhorar o código ou se ouver um erro devolva o erro encontrado")
                        .addSeparator()
                        .add("Devolva sugestões de como deixar o código mais intuitivo,legível e menor se possível");
     
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
