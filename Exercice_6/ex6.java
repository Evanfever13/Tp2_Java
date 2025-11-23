package Exercice_6;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ex6 {
    public static void main(String[] args){
        // Create and show a non-modal dialog on the EDT so main returns immediately
        SwingUtilities.invokeLater(() -> {
            JOptionPane pane = new JOptionPane("Salut, M.Parlermo!", JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = pane.createDialog("Message");
            dialog.setModal(false);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        });
    }
}