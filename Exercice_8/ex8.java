package Exercice_8;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
public class ex8 {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(() -> {
            JDialog dialog = new JDialog();
            JRadioButton radioButton = new JRadioButton("Normal");
            JRadioButton radioButton2 = new JRadioButton("Gras");
            JRadioButton radioButton3 = new JRadioButton("Italique");
            JRadioButton radioButton4 = new JRadioButton("Gras et Italique");

            // Ensure only one button can be selected at a time
            javax.swing.ButtonGroup group = new javax.swing.ButtonGroup();
            group.add(radioButton);
            group.add(radioButton2);
            group.add(radioButton3);
            group.add(radioButton4);

            // Default selection
            radioButton.setSelected(true);

            java.awt.event.ActionListener listener = e -> {
                JRadioButton src = (JRadioButton) e.getSource();
                System.out.println("Style " + src.getText() + " sélectionné");
            };

            radioButton.addActionListener(listener);
            radioButton2.addActionListener(listener);
            radioButton3.addActionListener(listener);
            radioButton4.addActionListener(listener);

            Object[] options = {radioButton, radioButton2, radioButton3, radioButton4};
            JOptionPane.showOptionDialog(dialog, "Choisissez le style de texte :", "Styles de Texte",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);
        });
    }
}