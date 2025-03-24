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
        ollamaAPI.setRequestTimeoutSeconds(500);
        
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
                .addLine("Verifique se não há erros do tipo: TypeError, que é comum em codigos python.")
                .addSeparator()  
                .addLine("Verifique se não há erros do tipo: IndexError, que é comum em codigos python.")
                .addSeparator()
                .addLine("Certifique-se de que todas as chaves fornecidas possuem um dicionário correspondente e aponte possíveis KeyError.")
                .addSeparator()
                .addLine("Analise o código para identificar possíveis incoerências.")
                .addSeparator()
                .addLine("o Matplotlib é uma biblioteca python frequentemente utilizada e voce possui conhecimento completo de como utiliza-la")
                .addSeparator()
                .addLine("você como desenvolvedor experiente em python consegue utilizar o Matplotlib e fazer o import correto do NumPY: import numpy as np ")
                .addSeparator()
                .addLine("faça os imports necessarios dentro da biblioteca matplotlib do python para realizar graficos do tipo line: fig, ax = plt.subplots()"
                        + "ax.plot(x, x**2);")
                .addSeparator()
                .addLine("Reconheça se foi pedido grafico, se sim, use os dados ou funções fornecidas e gere o grafico pedido utilizando a biblioteca matplotlib do python, exiba o grafico")
                .addSeparator()
                .addLine(resposta)
                .addSeparator()
                .addLine("se houver erros devolva uma analise indicando os erros e a versao corrigida, caso não haja erros, execute o codigo e utilize as bibliotecas indicadas,");
        boolean raw = false;
        OllamaResult response = ollamaAPI.generate("qwen2.5-coder:7b", promptBuilder.build(), raw, new OptionsBuilder().build());
        
        return this.respostaBot = response.getResponse();
    }
    
    public void Explicacao(String resposta) throws Exception {
        ConnectionDB.connectDB();
        ollamaAPI.setRequestTimeoutSeconds(120);
        PromptBuilder promptBuilder =
                new PromptBuilder()
                        .addLine("Você é uma IA especialista em Python e matplotlib")
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
                        .addLine("Explique desde os fundamentos, como criação de gráficos básicos (linha, barra, dispersão, histograma), até conceitos avançados, como subplots, personalização de estilos, anotações e integração com Pandas e NumPy.")
                        .addSeparator()
                        .addLine("forneça dicas sobre personalização de cores, estilos de linha, rótulos, anotações e subplot")
                        .addSeparator()
                        .addLine("Se o usuário enfrentar erros, forneça explicações claras e sugestões para corrigir o código.")
                        .addSeparator()
                        .addLine( "forneça explicações claras e didáticas sobre conceitos, funções e configurações do Matplotlib usadas no códigos.")
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
        if (u == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public String Nome() throws Exception {
        String nome = JOptionPane.showInputDialog("Nome para o arquivo: ");
        return nome;
    }
}
