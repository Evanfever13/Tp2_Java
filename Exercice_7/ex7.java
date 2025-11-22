package Exercice_7;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

// application swing démontrant deux styles de boutons avec effets visuels
public class ex7 extends JFrame {
    private static final Color FOND_PRINCIPAL = new Color(230, 240, 255);
    private static final Color BLEU_CLAIR = new Color(100, 150, 255);
    private static final Color BLEU_HOVER = new Color(70, 120, 230);
    private static final Color ROSE_CLAIR = new Color(255, 120, 180);
    private static final Color ROSE_HOVER = new Color(255, 80, 140);

    public ex7() {
        configurerFenetre();
        add(creerPanneauPrincipal());
    }

    // configure les parametres de la fenetre principale
    private void configurerFenetre() {
        setTitle("Test des boutons");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(FOND_PRINCIPAL);
    }

    // cree le panneau principal contenant les boutons
    private JPanel creerPanneauPrincipal() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 15, 10, 15);
        
        panel.add(creerBouton("Bouton Simple", BLEU_CLAIR, BLEU_HOVER, new Font("Arial", Font.BOLD, 18)), gbc);
        
        gbc.gridx = 1;
        panel.add(creerBouton("Bouton Fantaisie", ROSE_CLAIR, ROSE_HOVER, new Font("Segoe UI", Font.ITALIC, 18)), gbc);

        return panel;
    }

    // cree un bouton stylise avec effet hover et action au clic
    private JButton creerBouton(String texte, Color couleurNormale, Color couleurHover, Font police) {
        JButton bouton = new JButton(texte);
        bouton.setPreferredSize(new Dimension(220, 70));
        bouton.setFont(police);
        bouton.setBackground(couleurNormale);
        bouton.setForeground(Color.WHITE);
        bouton.setFocusPainted(false);
        bouton.setBorderPainted(false);
        bouton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // bordure arrondie avec effet d'ombre
        bouton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(couleurNormale.darker(), 2, true),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));

        // action au clic
        bouton.addActionListener(e -> 
            JOptionPane.showMessageDialog(this, 
                "Vous avez clique sur : " + texte, 
                "Information", 
                JOptionPane.INFORMATION_MESSAGE)
        );

        // effet hover
        ajouterEffetHover(bouton, couleurNormale, couleurHover);

        return bouton;
    }

    // ajoute un effet de survol qui change la couleur du bouton
    private void ajouterEffetHover(JButton bouton, Color couleurNormale, Color couleurHover) {
        bouton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                bouton.setBackground(couleurHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bouton.setBackground(couleurNormale);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ex7().setVisible(true));
    }
}
