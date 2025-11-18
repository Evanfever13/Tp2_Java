package Exercice_7;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ex7 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test des boutons");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1650, 950);
            frame.setLocationRelativeTo(null);

            frame.getContentPane().setBackground(new Color(230, 240, 255));

            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 40));
            panel.setOpaque(false);

            JButton boutonSimple = new JButton("Bouton simple");
            boutonSimple.setPreferredSize(new Dimension(200, 60));
            boutonSimple.setFont(new Font("Arial", Font.BOLD, 18));
            boutonSimple.setBackground(new Color(180, 220, 255));

            JButton boutonFantaisie = new JButton("Bouton fantaisie");
            boutonFantaisie.setPreferredSize(new Dimension(220, 70));
            boutonFantaisie.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
            boutonFantaisie.setBackground(new Color(255, 180, 200));

            boutonSimple.addActionListener(e -> {
                JOptionPane.showMessageDialog(
                    frame,
                    "Vous avez appuyé sur : Bouton simple",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE
                );
            });

            boutonFantaisie.addActionListener(e -> {
                JOptionPane.showMessageDialog(
                    frame,
                    "Vous avez appuyé sur : Bouton fantaisie",
                    "Information",
                    JOptionPane.INFORMATION_MESSAGE
                );
            });

            // Effet de survol avec MouseListener
            boutonFantaisie.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    boutonFantaisie.setBackground(new Color(255, 100, 150)); // couleur survol
                }
                public void mouseExited(MouseEvent e) {
                    boutonFantaisie.setBackground(new Color(255, 180, 200)); // couleur normale
                }
            });

            boutonSimple.addMouseListener(new MouseAdapter() {
                public void mouseEntered(MouseEvent e) {
                    boutonSimple.setBackground(new Color(255, 100, 150)); // couleur survol
                }
                public void mouseExited(MouseEvent e) {
                    boutonSimple.setBackground(new Color(255, 180, 200)); // couleur normale
                }
            });


            panel.add(boutonSimple);
            panel.add(boutonFantaisie);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
