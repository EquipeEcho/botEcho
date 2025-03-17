import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class frame {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1200, 1000);
        frame.getContentPane().setBackground(Color.gray);

        JPanel painel = new JPanel();
        painel.setBackground(Color.DARK_GRAY);
        painel.setBounds(0, 0, 250, frame.getHeight());
        painel.setLayout(null);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                painel.setBounds(0, 0, 250, frame.getHeight());
            }
        });

        JButton btnRun = new JButton("Run");
        btnRun.setBounds(25, 50, 200, 100);
        painel.add(btnRun);
        frame.add(painel);

        JButton btnGrafico = new JButton("Gráfico");
        btnGrafico.setBounds(25, 150, 200, 100);
        painel.add(btnGrafico);

        JTextArea texto = new JTextArea();
        texto.setFont(texto.getFont().deriveFont(16f));
        texto.setBackground(Color.BLACK);
        texto.setForeground(Color.GREEN);

        JScrollPane scrollPane = new JScrollPane(texto);
        scrollPane.setBounds(260, 10, 1000, 540);

        frame.add(scrollPane);

        btnRun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = texto.getText(); // Todo código escrito dentro do Text area vem para essa variável
                System.out.println(codigo);
            }
        });

        frame.setVisible(true);
    }
}
