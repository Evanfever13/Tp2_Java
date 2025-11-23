package Exercice_9;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;

public class ex9 extends JFrame {
    private static final int NOMBRE_CARTES = 3;
    private static final int LARGEUR_CARTE = 150;
    private static final int HAUTEUR_CARTE = 200;
    private static final String DOSSIER_IMAGES = "Exercice_9/images"; // chemin de dossier des images
    
    private final JLabel[] cartesLabels;

    public ex9() {
        configurerFenetre();
        cartesLabels = creerInterfaceGraphique();
    }

    // configure la fenetre avec dimensions, titre et fond vert type poker.
    private void configurerFenetre() {
        setTitle("Tirage de Cartes Aleatoire");
        setSize(650, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(34, 139, 34)); // fond vert type table de poker
    }

    // cree les composants graphiques et retourne les labels pour les cartes.
    private JLabel[] creerInterfaceGraphique() {
        // panneau pour les cartes (disposition horizontale)
        JPanel panneauCartes = new JPanel(new GridLayout(1, NOMBRE_CARTES, 15, 15));
        panneauCartes.setOpaque(false);
        panneauCartes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel[] labels = new JLabel[NOMBRE_CARTES];
        
        // creation des labels pour afficher les cartes avec bordures blanches
        for (int i = 0; i < NOMBRE_CARTES; i++) {
            labels[i] = new JLabel();
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            labels[i].setPreferredSize(new Dimension(LARGEUR_CARTE, HAUTEUR_CARTE));
            // Bordure composee : ligne blanche exterieure + padding interieur
            labels[i].setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 2),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
            ));
            labels[i].setBackground(Color.WHITE);
            labels[i].setOpaque(true);
            panneauCartes.add(labels[i]);
        }

        // panneau principal pour centrer les cartes avec GridBagLayout
        JPanel panneauPrincipal = new JPanel(new GridBagLayout());
        panneauPrincipal.setOpaque(false);
        panneauPrincipal.add(panneauCartes);

        // bouton de tirage avec style personnalise
        JButton boutonTirer = new JButton("Tirer 3 cartes");
        boutonTirer.setFont(new Font("Arial", Font.BOLD, 16));
        boutonTirer.setBackground(new Color(220, 20, 60)); // Rouge
        boutonTirer.setForeground(Color.WHITE);
        boutonTirer.setFocusPainted(false);
        boutonTirer.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        boutonTirer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boutonTirer.addActionListener(e -> tirerCartes());
        
        // effet hover : change la couleur du bouton au survol
        boutonTirer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boutonTirer.setBackground(new Color(255, 69, 96)); // rouge plus clair
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boutonTirer.setBackground(new Color(220, 20, 60)); // rouge original
            }
        });
        
        // panneau pour le bouton avec padding
        JPanel panneauBouton = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 15));
        panneauBouton.setOpaque(false);
        panneauBouton.add(boutonTirer);

        add(panneauPrincipal, BorderLayout.CENTER);
        add(panneauBouton, BorderLayout.SOUTH);
        
        return labels;
    }

    // tire aleatoirement 3 cartes apres verification du nombre d'images disponibles.
    private void tirerCartes() {
        List<File> imagesDisponibles = chargerImages();
        
        if (imagesDisponibles.size() < NOMBRE_CARTES) {
            afficherErreur("Pas assez d'images dans le dossier ! (minimum " + NOMBRE_CARTES + ")");
            return;
        }

        Collections.shuffle(imagesDisponibles);
        afficherCartes(imagesDisponibles);
    }

    // charge toutes les images PNG et JPG du dossier specifie.
    private List<File> chargerImages() {
        File dossier = new File(DOSSIER_IMAGES);
        List<File> images = new ArrayList<>();
        
        if (!dossier.exists() || !dossier.isDirectory()) {
            return images;
        }

        // filtre pour ne garder que les fichiers .png et .jpg
        File[] fichiers = dossier.listFiles((dir, nom) -> 
            nom.toLowerCase().endsWith(".png") || nom.toLowerCase().endsWith(".jpg")
        );

        if (fichiers != null) {
            Collections.addAll(images, fichiers);
        }
        
        return images;
    }

    // affiche et redimensionne les cartes selectionnees dans l'interface.
    private void afficherCartes(List<File> images) {
        for (int i = 0; i < NOMBRE_CARTES; i++) {
            ImageIcon icone = new ImageIcon(images.get(i).getAbsolutePath());
            // redimensionnement avec algorithme SCALE_SMOOTH pour une meilleure qualite
            Image imageRedimensionnee = icone.getImage().getScaledInstance(
                LARGEUR_CARTE, HAUTEUR_CARTE, Image.SCALE_SMOOTH
            );
            cartesLabels[i].setIcon(new ImageIcon(imageRedimensionnee));
        }
    }

    private void afficherErreur(String message) {
        JOptionPane.showMessageDialog(this, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ex9 fenetre = new ex9();
            fenetre.setVisible(true);
        });
    }
}