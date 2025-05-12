/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import dao.ConnectionDB;
import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;
import io.github.ollama4j.utils.PromptBuilder;
import java.sql.Connection;
import javax.swing.JOptionPane;

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
                .addLine("Você é um desenvolvedor especialista em Python, com conhecimento abrangente para detectar erros, corrigir codigos ou simplesmente usar bibliotecas")
                .addSeparator()
                .addLine("Analise códigos na linguagem Python para verificar se estão escritos corretamente. Se estiver correto, execute o que foi pedido e exiba a mensagem: seu codigo não possui erros.caso haja algum erro, verifique, exiba e explique apenas o erro que houver")
                .addSeparator()
                .addLine("verifique se não há erros do tipo SyntaxError, que é comum em codigos python. Se houver erro mostre, caso não haja, não necessita mostrar.")
                .addSeparator()        
                .addLine("verifique se não há erros do tipo IdentationError, que é comum em codigos python. Se houver erro mostre, caso não haja, não necessita mostrar.")
                .addSeparator()
                .addLine("Verifique se não há erros do tipo NameError, que é comum em codigos python. Se houver mostre, caso não haja, não necessita mostrar.")
                .addSeparator()
                .addLine("Verifique se não há erros do tipo: TypeError, que é comum em codigos python. Se houver mostre, caso não haja, não necessita mostrar.")
                .addSeparator()  
                .addLine("Verifique se não há erros do tipo: IndexError, que é comum em codigos python. Se houver mostre, caso não haja, não necessita mostrar.")
                .addSeparator()  
                .addLine("Verifique se não há erros do tipo: AttributeError, que é comum em codigos python.Se houver mostre, caso não haja, não necessita mostrar.")
                .addSeparator()  
                .addLine("Verifique se não há erros do tipo: ImportError, que é comum em codigos python. Se houver mostre, caso não haja, não necessita mostrar.")       
                .addSeparator()
                .addLine("Verifique se não há erros do tipo: Unhashable Type Error, que é comum em codigos python.Se houver mostre, caso não haja, não necessita mostrar.") 
                .addSeparator()
                .addLine("Verifique se não há erros do tipo: ZeroDivisionError, que é comum em codigos python. Se houver mostre, caso não haja, não necessita mostrar.")  
                .addSeparator()
                .addLine("Verifique se não há erros do tipo: StopIteration, que é comum em codigos python. Se houver mostre, caso não haja, não necessita mostrar.")       
                .addSeparator()
                .addLine("Verifique se não há erros do tipo: GeneratorExit, que é comum em codigos python. Se houver mostre, caso não haja, não necessita mostrar.")       
                .addSeparator()
                .addLine("Verifique se não há erros do tipo: ValueError, que é comum em codigos python. Se houver mostre, caso não haja, não necessita mostrar.")       
                .addSeparator()
                .addLine("Verifique se não há erros do tipo: FileNotFoundError, que é comum em codigos python.Se houver mostre, caso não haja, não necessita mostrar.")      
                .addSeparator()
                .addLine("Verifique se não há erros do tipo: StopIteration, que é comum em codigos python. Se houver mostre, caso não haja, não necessita mostrar.")       
                .addSeparator()
                .addLine("Verifique se não há erros do tipo: KeyError. Se houver mostre, caso não haja, não necessita mostrar.")
                .addSeparator()
                .addLine("Verifique se não há erros do tipo: OverflowError. Se houver mostre, caso não haja, não necessita mostrar.")
                .addSeparator()
                .addLine("Verifique se não há erros do tipo:RuntimeError. Se houver mostre, caso não haja, não necessita mostrar.")
                .addSeparator()
                .addLine("Verifique se não há erros do tipo: MemoryError. Se houver mostre, caso não haja, não necessita mostrar.")
                .addSeparator()
                .addLine("o Matplotlib é uma biblioteca python frequentemente utilizada e voce possui conhecimento completo de como utiliza-la")
                .addSeparator()
                .addLine("você como desenvolvedor experiente em python consegue utilizar o Matplotlib e fazer o import correto do NumPY: import numpy as np ")
                .addSeparator()
                .addLine("Reconheça se foi pedido grafico, se sim, use os dados ou funções fornecidas e gere o grafico pedido utilizando a biblioteca matplotlib do python e exiba o grafico, se for pedido")
                .addSeparator()
                .addLine(resposta);
                //.addSeparator()
                //.addLine("se houver erros devolva uma analise indicando os erros e a versao corrigida, caso não haja erros, execute o codigo e utilize as bibliotecas indicadas,");
        boolean raw = false;
        OllamaResult response = ollamaAPI.generate("qwen2.5-coder:7b", promptBuilder.build(), raw, new OptionsBuilder().build());
        
        return this.respostaBot = response.getResponse();
    }
    
    public void Explicacao(String resposta) throws Exception {
        ConnectionDB.connectDB();
        ollamaAPI.setRequestTimeoutSeconds(500);
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
        ollamaAPI.setRequestTimeoutSeconds(500);
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
    
    public void Document(String resposta) throws Exception{
    ConnectionDB.connectDB();
    ollamaAPI.setRequestTimeoutSeconds(500);
    String promptIA = "Faça a documentação do seguinte código Python com comentários e docstrings:\n"+resposta;
    String erro = "Caso haja algum erro, apenas retorne o erro encontrado";
    PromptBuilder promptBuilder = new PromptBuilder()
            .addLine(promptIA)
            .addSeparator();
    
    
    boolean raw = false;
    OllamaResult response = ollamaAPI.generate("qwen2.5-coder:7b", promptBuilder.build(), raw, new OptionsBuilder().build());
        
        
    this.respostaBot = response.getResponse();
    }

    public String respostaBot (){
    return this.respostaBot;
    }
    
    public Boolean Utilidade() throws Exception{
        String[] opcoes = {"Sim", "Não"};
        int u = JOptionPane.showOptionDialog(null, "Essa resposta foi útil para você?", "Feedback", JOptionPane.DEFAULT_OPTION,  JOptionPane.PLAIN_MESSAGE, null, opcoes, 1);
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
