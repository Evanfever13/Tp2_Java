package Exercice_8;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
public class ex8 {
    public static void main(String[] args){
        JDialog dialog = new JDialog();
        JRadioButton radioButton = new JRadioButton("Normal");
        JRadioButton radioButton2 = new JRadioButton("Gras");
        JRadioButton radioButton3 = new JRadioButton("Italique");
        JRadioButton radioButton4 = new JRadioButton("Gras et Italique");
        JOptionPane.showMessageDialog(dialog, "Salut, M.Parlermo!");
        JDialog.showMessageDialog(dialog, radioButton, radioButton2, radioButton3, radioButton4, "Choisissez le style de police", JOptionPane.PLAIN_MESSAGE);
    }
}