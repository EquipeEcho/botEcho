/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;


import java.awt.Component;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import gui.SplashScreen;
import dao.ConnectionDB;
import dao.Dao;
import dao.DateTime;
import Api.test.ExecPy;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class UI extends javax.swing.JFrame {
    public char ia;
    public int op;
    private String ut; 
    private java.io.File currentFile;
    private JTextArea box = new JTextArea();
    private JTextArea box1 = new JTextArea();
    
    /**
     * Creates new form UI
     */
public UI() {
    initComponents();
    

    applyCustomStyles(); 
}
private void applyCustomStyles() {
    
    
  
    Color bgColorDark = new Color(70, 70, 70);       
    Color bgColorMedium = new Color(100, 100, 100);      
    Color textColorLight = new Color(220, 220, 220);    
    Color accentColor = new Color(208,210,106);     
    Color buttonHoverBgColor = new Color(75, 75, 75); 

    
    Font fontGeneral, fontGeneralBold, fontTitle, fontMonospaced;
    try {
        fontGeneral = new Font("Open Sans", Font.PLAIN, 14);
        if (!new Font(fontGeneral.getFamily(), Font.PLAIN, 1).getFamily().equals("Open Sans")) throw new Exception();
    } catch (Exception e) { fontGeneral = new Font("SansSerif", Font.PLAIN, 14); }
    try {
        fontGeneralBold = new Font("Open Sans", Font.BOLD, 14);
        if (!new Font(fontGeneralBold.getFamily(), Font.BOLD, 1).getFamily().equals("Open Sans")) throw new Exception();
    } catch (Exception e) { fontGeneralBold = new Font("SansSerif", Font.BOLD, 14); }
    try {
        fontTitle = new Font("Open Sans", Font.BOLD, 18);
        if (!new Font(fontTitle.getFamily(), Font.BOLD, 1).getFamily().equals("Open Sans")) throw new Exception();
    } catch (Exception e) { fontTitle = new Font("SansSerif", Font.BOLD, 18); }
    try {
        fontMonospaced = new Font("Consolas", Font.PLAIN, 14);
        if (!new Font(fontMonospaced.getFamily(), Font.PLAIN, 1).getFamily().equals("Consolas")) throw new Exception();
    } catch (Exception e) { fontMonospaced = new Font("Monospaced", Font.PLAIN, 14); }

    // Frame Principal
    getContentPane().setBackground(bgColorDark);
    // setTitle("BotEcho IDE"); // Mantenha ou ajuste o título conforme preferir

    // Ícone do Bender (jLabel3)
    try {
        ImageIcon benderIcon = new ImageIcon("bender.png"); // Caminho para o novo ícone
        Image image = benderIcon.getImage().getScaledInstance(170, 300, Image.SCALE_AREA_AVERAGING); // Ajuste o tamanho se necessário
        jLabel5.setIcon(new ImageIcon(image));
        
        
        jLabel5.setText(""); // Limpa o texto do label do ícone
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
    } catch (Exception e) {
        jLabel5.setText("[Ícone Bender]");
        System.err.println("Erro ao carregar o ícone Bender para jLabel3: " + e.getMessage());
    }

    // JTextAreas para números de linha (box, box1) - Assumindo que são os campos 'box' e 'box1' da sua classe
    // Se 'this.box' e 'this.box1' são os JTextAreas para numeração de linhas:
    if (this.box != null) { 
        this.box.setBackground(bgColorDark); 
        this.box.setForeground(textColorLight); 
        this.box.setFont(fontMonospaced); 
        this.box.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, accentColor));
        this.box.setEditable(false);
    }
    if (this.box1 != null) {
        this.box1.setBackground(bgColorDark);
        this.box1.setForeground(textColorLight);
        this.box1.setFont(fontMonospaced);
        this.box1.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, accentColor));
        this.box1.setEditable(false);
    }

    // JTextArea de Input (jTextArea1)
    jTextArea1.setBackground(bgColorMedium);
    jTextArea1.setForeground(textColorLight);
    jTextArea1.setFont(fontMonospaced);
    jTextArea1.setCaretColor(textColorLight);
    jTextArea1.setLineWrap(true);
    jTextArea1.setWrapStyleWord(true);
    jScrollPane1.setBorder(BorderFactory.createLineBorder(accentColor, 1));
    jScrollPane1.getViewport().setBackground(bgColorMedium);

    // JTextArea de Output (jTextArea2)
    jTextArea2.setBackground(bgColorMedium);
    jTextArea2.setForeground(textColorLight);
    jTextArea2.setFont(fontMonospaced);
    jTextArea2.setCaretColor(textColorLight);
    jTextArea2.setEditable(false);
    jTextArea2.setLineWrap(true);
    jTextArea2.setWrapStyleWord(true);
    jScrollPane2.setBorder(BorderFactory.createLineBorder(accentColor, 1));
    jScrollPane2.getViewport().setBackground(bgColorMedium);

    // Botão Run (jButton3)
    styleButton(jButton3, fontGeneralBold, bgColorMedium, textColorLight, accentColor, buttonHoverBgColor);
    jButton3.setText("Run"); // Traduzido para português

    // Labels
    jLabel1.setFont(fontTitle); // "BotEcho" (título à esquerda, abaixo do ícone)
    jLabel1.setForeground(textColorLight);
    // jLabel1.setHorizontalAlignment(SwingConstants.CENTER); // Centralizar se necessário

    jLabel2.setFont(fontTitle); // "Input"
    jLabel2.setForeground(textColorLight);

    jLabel4.setFont(fontTitle); // "Output"
    jLabel4.setForeground(textColorLight);

    // Botão não utilizado (jButton1) - Ocultar
    if (jButton1 != null) jButton1.setVisible(false);
    
    

    // Barra de Menu (jMenuBar1) e Menus
    jMenuBar1.setBackground(bgColorDark);
    jMenuBar1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, accentColor)); // Borda inferior

    for (int i = 0; i < jMenuBar1.getMenuCount(); i++) {
        JMenu menu = jMenuBar1.getMenu(i);
        menu.setForeground(textColorLight);
        menu.setFont(fontGeneralBold);
        menu.setOpaque(true);
        menu.setBackground(bgColorDark);

        for (Component menuItemComponent : menu.getMenuComponents()) {
            if (menuItemComponent instanceof JMenuItem) {
                JMenuItem menuItem = (JMenuItem) menuItemComponent;
                menuItem.setFont(fontGeneral);
                menuItem.setForeground(textColorLight);
                menuItem.setBackground(bgColorMedium); // Fundo para itens do dropdown
                menuItem.setOpaque(true);
            }
        }
    }
}

private void styleButton(JButton button, Font font, Color bg, Color fg, Color border, Color hoverBg) {
    if (button == null) return;
    button.setFont(font);
    button.setBackground(bg);
    button.setForeground(fg);
    button.setFocusPainted(false);
    button.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(border, 1),
        BorderFactory.createEmptyBorder(8, 25, 8, 25) 
    ));
    button.setOpaque(true);

    button.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setBackground(hoverBg);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setBackground(bg);
        }
    });
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        analise = new javax.swing.JMenuItem();
        explicacao = new javax.swing.JMenuItem();
        sugestao = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bot Echo IDE");
        setBackground(new java.awt.Color(0, 102, 102));
        setForeground(java.awt.Color.blue);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextArea1CaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);
        jTextArea1.getAccessibleContext().setAccessibleName("areaUsuario");

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextArea2CaretUpdate(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea2);

        jButton3.setText("Run");
        jButton3.setMaximumSize(new java.awt.Dimension(94, 24));
        jButton3.setMinimumSize(new java.awt.Dimension(94, 24));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BotEcho");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Input");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Output");

        jButton1.setText("jButton1");

        jMenu1.setText("Arquivo");

        jMenuItem1.setText("Abrir arquivo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Salvar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Salvar como...");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Inteligência Artificial (IA)");

        analise.setText("Realizar análise");
        analise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analiseActionPerformed(evt);
            }
        });
        jMenu5.add(analise);

        explicacao.setText("Gerar explicação");
        explicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                explicacaoActionPerformed(evt);
            }
        });
        jMenu5.add(explicacao);

        sugestao.setText("Sugestões de melhoria");
        sugestao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sugestaoActionPerformed(evt);
            }
        });
        jMenu5.add(sugestao);

        jMenuItem5.setText("Gerar documentação");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        jMenu3.setText("Histórico");

        jMenuItem4.setText("Gerar histórico");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu6.setText("Bash");
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        jMenu2.setText("Ajuda");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 1035, Short.MAX_VALUE)))
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        getAccessibleContext().setAccessibleName("BotEcho IDE");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ExecPy ep = new ExecPy();
        ep.exec(jTextArea1.getText());
        jTextArea2.setText(ep.getRes());
    }//GEN-LAST:event_jButton3ActionPerformed


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
    int result = fileChooser.showOpenDialog(this);
    
    if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
        this.currentFile = fileChooser.getSelectedFile();
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(this.currentFile))) {
            StringBuilder conteudo = new StringBuilder();
            String linha;
            setTitle("Bot Echo IDE - " + this.currentFile.getName());
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
            jTextArea1.setText(conteudo.toString());
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao carregar arquivo: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (this.currentFile == null) {
            jMenuItem3ActionPerformed(evt);
        } else {
            try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(this.currentFile))) {
                writer.write(jTextArea1.getText());
                javax.swing.JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso!");
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao salvar arquivo: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(java.io.File f) {
                return f.isDirectory() || f.getName().endsWith(".py");
            }
            @Override
            public String getDescription() {
                return "Python File (*.py)";
            }
        });
        int result = fileChooser.showSaveDialog(this);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            this.currentFile = fileChooser.getSelectedFile();
            if (!this.currentFile.getName().endsWith(".py")) {
              this.currentFile = new java.io.File(this.currentFile.getParent(),this.currentFile.getName() + ".py");
            }

            if (this.currentFile.exists()) {
                int overwrite = javax.swing.JOptionPane.showConfirmDialog(this,
                        "O arquivo já existe. Deseja substituí-lo?",
                        "Confirmar", javax.swing.JOptionPane.YES_NO_OPTION);
                if (overwrite != javax.swing.JOptionPane.YES_OPTION) {
                    return;
                }
            }

            try (java.io.BufferedWriter writer = new java.io.BufferedWriter(new java.io.FileWriter(this.currentFile))) {
                writer.write(jTextArea1.getText());
                setTitle("Bot Echo IDE - " + this.currentFile.getName());
                javax.swing.JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso!");
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao salvar arquivo: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void analiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analiseActionPerformed
        Prompt prompt = new Prompt();
        Connection conn = ConnectionDB.connectDB();

        try {
            prompt.Analise(jTextArea1.getText());
            jTextArea2.setText(prompt.respostaBot());
            Dao.insertDB(conn, prompt.respostaBot(), prompt.Utilidade(), 'A', prompt.Nome(), DateTime.getDataTime());
        } catch (Exception e) {
            e.printStackTrace(); // Print error details
            System.out.print("An error occurred: " + e.getMessage());
        }
    }//GEN-LAST:event_analiseActionPerformed

    private void explicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_explicacaoActionPerformed
        Prompt prompt = new Prompt();
        Connection conn = ConnectionDB.connectDB();

        try {
            prompt.Explicacao(jTextArea1.getText());
            jTextArea2.setText(prompt.respostaBot());
            Dao.insertDB(conn, prompt.respostaBot(), prompt.Utilidade(), 'E', prompt.Nome(), DateTime.getDataTime());
        } catch (Exception e) {
            e.printStackTrace(); // Print error details
            System.out.print("An error occurred: " + e.getMessage());
        } 
    }//GEN-LAST:event_explicacaoActionPerformed

    private void sugestaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sugestaoActionPerformed
        Prompt prompt = new Prompt();
        Connection conn = ConnectionDB.connectDB();

        try {
            prompt.Sugestao(jTextArea1.getText());
            jTextArea2.setText(prompt.respostaBot());

            Dao.insertDB(conn, prompt.respostaBot(), prompt.Utilidade(), 'S', prompt.Nome(), DateTime.getDataTime());
        } catch (Exception e) {
            e.printStackTrace(); // Print error details
            System.out.print("An error occurred: " + e.getMessage());
        }
        jTextArea2.setText(prompt.respostaBot());
    }//GEN-LAST:event_sugestaoActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Connection conn = ConnectionDB.connectDB();

        try {
            String[] opcoes = {"Análise", "Explicação", "Sugestão", "Documentação"};
            String[] colunas = new String[]{
                "Nome", "Data", "Resposta", "Tipo"
            };

            int op = JOptionPane.showOptionDialog(null, "Escolha o tipo dos prompts:", "Histórico de Visualizações", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (op == 0) {
                ia = 'A';
            } else if (op == 1) {
                ia = 'E';
            } else if (op == 2) {
                ia = 'S';
            } else if (op == 3){
                ia = 'D';
            } else if (op == JOptionPane.CLOSED_OPTION) {
                return;
            }

            DefaultTableModel tabelaHist = new DefaultTableModel(colunas, 0);
            ArrayList<Object[]> historico = Dao.selectDB(conn, ia);

            for (Object[] h : historico) {
                tabelaHist.addRow(h);
            }

            JTable tabelaHistorico = new JTable(tabelaHist);
            tabelaHistorico.setRowHeight(20);
            TableColumnModel columnModel = tabelaHistorico.getColumnModel();
            columnModel.getColumn(0).setWidth(100);
            columnModel.getColumn(1).setPreferredWidth(60);
            columnModel.getColumn(2).setPreferredWidth(250);
            columnModel.getColumn(3).setPreferredWidth(10);
            JFrame frameHistorico = new JFrame("Histórico de Prompts");
            frameHistorico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JScrollPane scroll = new JScrollPane(tabelaHistorico);
            frameHistorico.getContentPane().add(scroll);
            frameHistorico.pack();
            frameHistorico.setLocationRelativeTo(null);
            frameHistorico.setVisible(true);

            tabelaHistorico.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    int row = tabelaHistorico.rowAtPoint(evt.getPoint());
                    JScrollPane scroll = new JScrollPane(tabelaHistorico);

                    if (row >= 0) {
                        Object nome = tabelaHistorico.getValueAt(row, 0);
                        Object data = tabelaHistorico.getValueAt(row, 1);
                        Object resposta = tabelaHistorico.getValueAt(row, 2);

                        jTextArea1.setText("Nome: " + nome + "\nData: " + data + "\nResposta: \n" + resposta);
                        frameHistorico.dispose();
                    }
                }
            });

        } catch (SQLException er) {
            er.printStackTrace();
        } catch (Exception er) {
            throw new RuntimeException(er);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Connection conn = ConnectionDB.connectDB();
        Prompt prompt = new Prompt();

        try {
            prompt.Document(jTextArea1.getText());
            jTextArea2.setText(prompt.respostaBot());
            Dao.insertDB(conn, prompt.respostaBot(), prompt.Utilidade(), 'D', prompt.Nome(), DateTime.getDataTime());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error generating documentation");
            System.out.println("Error: " + e.getMessage());

        }

        jTextArea2.setText(prompt.respostaBot());
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jTextArea1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextArea1CaretUpdate
      int x,y = 1,c = 1;
        x = jTextArea1.getLineCount();
        StringBuilder sb = new StringBuilder();
        sb.append(" "+c);
        this.box.setText(sb.toString());
        jScrollPane1.setRowHeaderView(this.box);
        if(x != 1){
        while (x != y){
            c+=1;
            sb.append("\n").append(" "+c);
            this.box.setText(sb.toString());
            jScrollPane1.setRowHeaderView(this.box);
            y+=1;
        }}
    }//GEN-LAST:event_jTextArea1CaretUpdate

    private void jTextArea2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextArea2CaretUpdate
       int x,y = 1,c = 1;
        x = jTextArea1.getLineCount();
        StringBuilder sb = new StringBuilder();
        sb.append("  "+c);
        this.box.setText(sb.toString());
        jScrollPane1.setRowHeaderView(this.box);
        if(x != 1){
        while (x != y){
            c+=1;
            sb.append("\n").append(" "+c);
            this.box.setText(sb.toString());
            jScrollPane1.setRowHeaderView(this.box);
            y+=1;
        }}
    }//GEN-LAST:event_jTextArea2CaretUpdate

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        try {

                    String gitBashPath = "C:\\Program Files\\Git\\bin\\bash.exe";
                    

                    String command = "cmd.exe /c start \"\" \"C:\\Program Files\\Git\\bin\\bash.exe\"";


                    Runtime.getRuntime().exec(command);
                    
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao abrir o Git Bash como Administrador: " + ex.getMessage());                         
        };
    }//GEN-LAST:event_jMenu6MouseClicked
          
            
    /**
     * @param args the command line  
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);

            }
    });
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem analise;
    private javax.swing.JMenuItem explicacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JMenuItem sugestao;
    // End of variables declaration//GEN-END:variables
}
