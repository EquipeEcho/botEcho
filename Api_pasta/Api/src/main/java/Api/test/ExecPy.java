/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Api.test;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
/**
 *
 * @author Ryan
 */
public class ExecPy {
    private String res;

    public String getRes() {
        return res;
    }
    public void exec(String code){
    try{
    //Cria o arquivo e escreve dentro dele
    FileWriter file = new FileWriter("execPy.py");
    file.write(code);
    file.close();
    //cria o "cmd" coloca "Python execPy.py" fazendo que ele seja executado
    ProcessBuilder pb = new ProcessBuilder("Python","execPy.py"); 
    pb.redirectErrorStream(true);
    Process process = pb.start();
    
    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    StringBuilder output = new StringBuilder();
    String line;
    while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
    }

    process.waitFor();
    this.res = output.toString();

     } catch (IOException | InterruptedException e) {
     e.printStackTrace();
     res = "Error running Python code: " + e.getMessage();
     }
     
    }

    public void exec(String text, int op, char ia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
