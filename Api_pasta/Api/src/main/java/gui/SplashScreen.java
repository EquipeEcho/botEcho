/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

/**
 *
 * @author faelb
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplashScreen extends JFrame {

    public SplashScreen() {
        setTitle("BotEcho - Inicializando");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100, 600);
        setLocationRelativeTo(null);
        setUndecorated(true);

       
        Color backgroundColor = new Color(45, 45, 45); 
        Color textColor = new Color(220, 220, 220); 
        Color buttonColor = new Color(60, 60, 60); 
        Color buttonTextColor = new Color(200, 200, 200);
        Color borderColor = new Color(208,210,106);

        getContentPane().setBackground(backgroundColor);
        setLayout(new BorderLayout());
        getRootPane().setBorder(BorderFactory.createLineBorder(borderColor, 2));

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(backgroundColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;

       
        JLabel iconLabel = new JLabel();
        try {
            ImageIcon benderIcon = new ImageIcon(ClassLoader.getSystemResource("imagens/boteco_logo.png"));
            Image image = benderIcon.getImage().getScaledInstance(90, 90, Image.SCALE_DEFAULT);
            iconLabel.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            iconLabel.setText("(Ícone)"); 
            System.err.println("Erro ao carregar o ícone: " + e.getMessage());
        }
        mainPanel.add(iconLabel, gbc);


        JLabel titleLabel = new JLabel("Bem-Vindo ao BotEcho");
        titleLabel.setFont(new Font("Open Sans", Font.BOLD, 30)); 
        titleLabel.setForeground(textColor);
        mainPanel.add(titleLabel, gbc);

        
        JButton startButton = new JButton("Iniciar");
        startButton.setFont(new Font("Open Sans", Font.PLAIN, 18));
        startButton.setBackground(buttonColor);
        startButton.setForeground(buttonTextColor);
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(borderColor.brighter(), 1),
            BorderFactory.createEmptyBorder(10, 30, 10, 30) 
        ));
    
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startButton.setBackground(buttonColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                startButton.setBackground(buttonColor);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose();
                
                SwingUtilities.invokeLater(() -> {
                    UI ide = new UI();
                    ide.setVisible(true);
                });
            }
        });
        gbc.insets = new Insets(20, 10, 10, 10); 
        mainPanel.add(startButton, gbc);

        add(mainPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
       
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
        SwingUtilities.invokeLater(() -> {
            SplashScreen splash = new SplashScreen();
            splash.setVisible(true);
        });
    }
}


