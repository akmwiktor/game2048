import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Help extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextPane a2048IsASlidingTextPane;
    //    private JButton buttonCancel;
    Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
    public Help() {
        setContentPane(contentPane);
        a2048IsASlidingTextPane.enableInputMethods(false);
//        a2048IsASlidingTextPane.setEnabled(false);
        a2048IsASlidingTextPane.setEditable(false);
        setSize(350, 550);
        setTitle("Description of game2048");
        setLocation(screenSize.width / 2 -200, 100);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Help dialog = new Help();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
