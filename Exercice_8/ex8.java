package Exercice_8;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import java.awt.Font;

public class ex8 {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Use null parent so the option dialog is centered on screen
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
                System.out.println("Style " + src.getText() + " selectionne");
            };

            radioButton.addActionListener(listener);
            radioButton2.addActionListener(listener);
            radioButton3.addActionListener(listener);
            radioButton4.addActionListener(listener);

            javax.swing.JLabel messageLabel = new javax.swing.JLabel("Choisissez le style de texte : ");

            // Put radio buttons inside a panel so they are visible in the dialog
            javax.swing.JPanel panel = new javax.swing.JPanel();
            panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.Y_AXIS));
            panel.add(messageLabel);
            panel.add(radioButton);
            panel.add(radioButton2);
            panel.add(radioButton3);
            panel.add(radioButton4);

                java.awt.event.ActionListener updateLabel = e -> {
                    JRadioButton src = (JRadioButton) e.getSource();
                    // update text
                    messageLabel.setText("Choisissez le style de texte : " + src.getText());
                    // update font style according to selection
                    Font base = messageLabel.getFont();
                    int style = Font.PLAIN;
                    if (src == radioButton2) style = Font.BOLD;
                    else if (src == radioButton3) style = Font.ITALIC;
                    else if (src == radioButton4) style = Font.BOLD | Font.ITALIC;
                    messageLabel.setFont(base.deriveFont(style));
                };

                radioButton.addActionListener(updateLabel);
                radioButton2.addActionListener(updateLabel);
                radioButton3.addActionListener(updateLabel);
                radioButton4.addActionListener(updateLabel);

                // initialize label font according to default selection
                messageLabel.setFont(messageLabel.getFont().deriveFont(Font.PLAIN));

            // Initialize the label according to the default selection
            messageLabel.setText("Choisissez le style de texte : " + radioButton.getText());

            // Show a modal dialog containing the panel (OK to close)
            JOptionPane.showConfirmDialog(null, panel, "Styles de Texte",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        });
    }
}