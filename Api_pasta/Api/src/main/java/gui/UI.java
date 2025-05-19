/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;


import dao.ConnectionDB;
import dao.Dao;
import dao.DateTime;
import Api.test.ExecPy;
import java.awt.Color;
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
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.Image;
import java.awt.Dimension;
import com.formdev.flatlaf.FlatIntelliJLaf;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;

public class UI extends javax.swing.JFrame {
   public char ia;
    public int op;
    private String ut; 
    private java.io.File currentFile;
    
    public UI() {
        try {
         
            FlatIntelliJLaf.setup();
        } catch (Exception ex) {
            System.err.println("Falha ao inicializar o FlatLaf: " + ex.getMessage());
        }
        
       
        initComponents();
        
        
        applyCustomStyles();
        
        //  ícone do Bender
        try {
            ImageIcon benderIcon = null;
            try {
                benderIcon = new ImageIcon(getClass().getResource("bender.png"));
            } catch (Exception e) {
                System.err.println("Tentando carregar bender2.png do caminho absoluto como fallback.");
                benderIcon = new ImageIcon("bender.png"); 
            }
            
            if (benderIcon.getIconWidth() > 0) {
                Image image = benderIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                jLabel3.setIcon(new ImageIcon(image));
                jLabel3.setText("");
                jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
            } else {
                throw new Exception("Ícone inválido");
            }
        } catch (Exception e) {
            jLabel3.setText("");
            System.err.println("Erro ao carregar o ícone bender2.png: " + e.getMessage());
        }
}
@SuppressWarnings("unchecked")

private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        
        RSyntaxTextArea inputTextArea = new RSyntaxTextArea(20, 60);
        jScrollPane1 = new RTextScrollPane(inputTextArea);
        
        RSyntaxTextArea outputTextArea = new RSyntaxTextArea(20, 60);
        jScrollPane2 = new RTextScrollPane(outputTextArea);
        
        // RSyntaxTextArea  input
        inputTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
        inputTextArea.setCodeFoldingEnabled(true);
        inputTextArea.setAntiAliasingEnabled(true);
        inputTextArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        
        //  RSyntaxTextArea  output
        outputTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
        outputTextArea.setCodeFoldingEnabled(true);
        outputTextArea.setAntiAliasingEnabled(true);
        outputTextArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        outputTextArea.setEditable(false);
        
        //  variáveis 
        jTextArea1 = inputTextArea;
        jTextArea2 = outputTextArea;
        
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
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

        // Botão Run 
        jButton3.setText("Run");
        try {
            ImageIcon playIcon = new ImageIcon("play_icon.png");
            if (playIcon.getIconWidth() > 0) {
                Image img = playIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
                jButton3.setIcon(new ImageIcon(img));
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar ícone play: " + e.getMessage());
        }
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        // Labels
        jLabel1.setText("BotEcho");
        jLabel2.setText("Input");
        jLabel4.setText("Output");
        
        // Botão não utilizado
        jButton1.setText("jButton1");
        jButton1.setVisible(false);

        // Menu Arquivo 
        jMenu1.setText("Arquivo");
        
        jMenuItem1.setText("Abrir arquivo");
        try {
            ImageIcon folderIcon = new ImageIcon("folder_icon.png");
            if (folderIcon.getIconWidth() > 0) {
                Image img = folderIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
                jMenuItem1.setIcon(new ImageIcon(img));
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar ícone folder: " + e.getMessage());
        }
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Salvar");
        try {
            ImageIcon saveIcon = new ImageIcon("save_icon.png");
            if (saveIcon.getIconWidth() > 0) {
                Image img = saveIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
                jMenuItem2.setIcon(new ImageIcon(img));
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar ícone save: " + e.getMessage());
        }
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Salvar como...");
        try {
            ImageIcon saveIcon = new ImageIcon("save_icon.png");
            if (saveIcon.getIconWidth() > 0) {
                Image img = saveIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
                jMenuItem3.setIcon(new ImageIcon(img));
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar ícone save: " + e.getMessage());
        }
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenuBar1.add(jMenu1);

        // Menu IA 
        jMenu5.setText("Inteligência Artificial (IA)");
        try {
            ImageIcon aiIcon = new ImageIcon("ai_icon.png");
            if (aiIcon.getIconWidth() > 0) {
                Image img = aiIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
                jMenu5.setIcon(new ImageIcon(img));
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar ícone AI: " + e.getMessage());
        }
        
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

        // Menu Histórico
        jMenu3.setText("Histórico");
        jMenuItem4.setText("Gerar histórico");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);
        jMenuBar1.add(jMenu3);

        // Menu Bash 
        jMenu6.setText("Bash");
        try {
            ImageIcon terminalIcon = new ImageIcon("terminal_icon.png");
            if (terminalIcon.getIconWidth() > 0) {
                Image img = terminalIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
                jMenu6.setIcon(new ImageIcon(img));
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar ícone terminal: " + e.getMessage());
        }
        jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu6);

        // Menu Ajuda 
        jMenu2.setText("Ajuda");
        try {
            ImageIcon helpIcon = new ImageIcon("help_icon.png");
            if (helpIcon.getIconWidth() > 0) {
                Image img = helpIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
                jMenu2.setIcon(new ImageIcon(img));
            }
        } catch (Exception e) {
            System.err.println("Erro ao carregar ícone help: " + e.getMessage());
        }
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        // Layout
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                        .addComponent(jScrollPane2)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        getAccessibleContext().setAccessibleName("BotEcho IDE");

        pack();
        setLocationRelativeTo(null);
}

    
private void applyCustomStyles() {
    
       // Cores
        Color bgColorDark = new Color(43, 43, 43);       // Fundo escuro
        Color bgColorMedium = new Color(60, 63, 65);     // Fundo médio para áreas de texto
        Color textColorLight = new Color(211,211,211); // Texto claro
        Color textColorDark = new Color (28,28,28); // texto escuro           
        Color accentColor = new Color(75, 110, 175);     // Azul como cor de destaque
        Color currentLineColor = new Color(50, 50, 50);  // Cor da linha atual
        
        // Fontes
        Font fontGeneral, fontTitle, fontMonospaced;
        
       
        try {
            fontGeneral = new Font("Segoe UI", Font.PLAIN, 14);
        } catch (Exception e) { 
            fontGeneral = new Font("SansSerif", Font.PLAIN, 14); 
        }
        
        try {
            fontTitle = new Font("Segoe UI", Font.BOLD, 18);
        } catch (Exception e) { 
            fontTitle = new Font("SansSerif", Font.BOLD, 18); 
        }
        
        try {
            fontMonospaced = new Font("Consolas", Font.PLAIN, 14);
        } catch (Exception e) { 
            fontMonospaced = new Font("Monospaced", Font.PLAIN, 14); 
        }

        //  cores de fundo
        getContentPane().setBackground(bgColorDark);
        
        //  Input (jTextArea1)
        ((RSyntaxTextArea)jTextArea1).setBackground(bgColorMedium);
        ((RSyntaxTextArea)jTextArea1).setForeground(textColorLight);
        ((RSyntaxTextArea)jTextArea1).setFont(fontMonospaced);
        ((RSyntaxTextArea)jTextArea1).setCaretColor(textColorLight);
        ((RSyntaxTextArea)jTextArea1).setCurrentLineHighlightColor(currentLineColor);
        ((RSyntaxTextArea)jTextArea1).setMarkOccurrences(true);
        ((RSyntaxTextArea)jTextArea1).setBracketMatchingEnabled(true);
        
        //  tema RSyntaxTextArea
        try {
            Theme theme = Theme.load(getClass().getResourceAsStream(
                    "/org/fife/ui/rsyntaxtextarea/themes/dark.xml"));
            theme.apply((RSyntaxTextArea)jTextArea1);
            theme.apply((RSyntaxTextArea)jTextArea2);
        } catch (Exception e) {
            // Fallback para configuração manual se o tema não puder ser carregado
            ((RSyntaxTextArea)jTextArea1).setBackground(bgColorMedium);
            ((RSyntaxTextArea)jTextArea1).setForeground(textColorLight);
            ((RSyntaxTextArea)jTextArea2).setBackground(bgColorMedium);
            ((RSyntaxTextArea)jTextArea2).setForeground(textColorLight);
        }
        
        // bordas do RTextScrollPane
        if (jScrollPane1 instanceof RTextScrollPane) {
            ((RTextScrollPane)jScrollPane1).setLineNumbersEnabled(true);
            ((RTextScrollPane)jScrollPane1).getGutter().setBackground(bgColorDark);
            ((RTextScrollPane)jScrollPane1).getGutter().setBorderColor(accentColor);
        }
        jScrollPane1.setBorder(BorderFactory.createLineBorder(accentColor, 1));

        // Estilizar RSyntaxTextArea de Output (jTextArea2)
        ((RSyntaxTextArea)jTextArea2).setBackground(bgColorMedium);
        ((RSyntaxTextArea)jTextArea2).setForeground(textColorLight);
        ((RSyntaxTextArea)jTextArea2).setFont(fontMonospaced);
        ((RSyntaxTextArea)jTextArea2).setCaretColor(textColorLight);
        ((RSyntaxTextArea)jTextArea2).setCurrentLineHighlightColor(currentLineColor);
        
        // Configurar bordas do RTextScrollPane para output
        if (jScrollPane2 instanceof RTextScrollPane) {
            ((RTextScrollPane)jScrollPane2).setLineNumbersEnabled(true);
            ((RTextScrollPane)jScrollPane2).getGutter().setBackground(bgColorDark);
            ((RTextScrollPane)jScrollPane2).getGutter().setBorderColor(accentColor);
        }
        jScrollPane2.setBorder(BorderFactory.createLineBorder(accentColor, 1));

        // Estilizar botão Run (jButton3)
        jButton3.setBackground(accentColor);
        jButton3.setForeground(textColorLight);
        jButton3.setFont(fontGeneral);
        jButton3.setFocusPainted(false);
        jButton3.setBorderPainted(false);

        // Estilizar labels
        jLabel1.setFont(fontTitle);
        jLabel1.setForeground(textColorLight);
        jLabel2.setFont(fontTitle);
        jLabel2.setForeground(textColorLight);
        jLabel4.setFont(fontTitle);
        jLabel4.setForeground(textColorLight);

        // barra de menu
        jMenuBar1.setBackground(bgColorDark);
        jMenuBar1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, accentColor));
        
    
        for (int i = 0; i < jMenuBar1.getMenuCount(); i++) {
            JMenu menu = jMenuBar1.getMenu(i);
            if (menu != null) {
                menu.setForeground(textColorDark);
                menu.setFont(fontGeneral);
                
                // itens de menu
                for (int j = 0; j < menu.getItemCount(); j++) {
                    JMenuItem item = menu.getItem(j);
                    if (item != null) {
                        item.setBackground(bgColorDark);
                        item.setForeground(textColorDark);
                        item.setFont(fontGeneral);
                    }
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
  /*  @SuppressWarnings("unchecked")
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
*/
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
                jTextArea1.setCaretPosition(0);
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
                javax.swing.JOptionPane.showMessageDialog(this, "Arquivo salvo como '" + this.currentFile.getName() + "' com sucesso!");
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
            e.printStackTrace(); // Print error 
            System.out.print("An error occurred: " + e.getMessage());
        }
        jTextArea2.setText(prompt.respostaBot());
    }//GEN-LAST:event_sugestaoActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         Dao d = new Dao();
        ConnectionDB c = new ConnectionDB();
        try (Connection conn = c.connect()) {
            ArrayList<String> historico = d.gerarHistorico(conn);
            JFrame frameHistorico = new JFrame("Histórico de Comandos");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Comandos");
            for(String comando : historico){
                model.addRow(new Object[]{comando});
            }
            JTable tabelaHistorico = new JTable(model);
            tabelaHistorico.setEnabled(false);
            JScrollPane scrollPaneHistorico = new JScrollPane(tabelaHistorico);
            frameHistorico.add(scrollPaneHistorico);
            frameHistorico.pack();
            frameHistorico.setLocationRelativeTo(this); 
            frameHistorico.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao acessar o banco de dados para o histórico: " + e.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao gerar histórico: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
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


        jTextArea2.setText(prompt.respostaBot());
    }    
        
        
        
        
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jTextArea1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextArea1CaretUpdate
     //
    }//GEN-LAST:event_jTextArea1CaretUpdate

    private void jTextArea2CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextArea2CaretUpdate
       //
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
            // Aplicar FlatLaf
            FlatIntelliJLaf.setup();
        } catch (Exception ex) {
            System.err.println("Falha ao inicializar o FlatLaf: " + ex.getMessage());
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
