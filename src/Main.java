import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
        JMenuBar mb = new JMenuBar();

        JMenu menuFile = new JMenu();
        JMenu help = new JMenu();

        JMenuItem open = new JMenuItem();
        JMenuItem exit = new JMenuItem();
        JMenuItem aboutGame = new JMenuItem();

        Font font = new Font("Courier New", Font.BOLD, 18);
        menuFile.setFont(font);
        help.setFont(font);
        menuFile.setText("Game");
        help.setText("Help");

        font = new Font("Courier", Font.PLAIN, 18);
        open.setFont(font);
        exit.setFont(font);
        aboutGame.setFont(font);
        open.setText("New game");
        exit.setText("Exit");
        aboutGame.setText("About game2048");
        menuFile.add(open);
        menuFile.add(exit);
        help.add(aboutGame);

        mb.add(menuFile);
        mb.add(help);

        exit.addActionListener(ActionEvent -> System.exit(0));

        JFrame f = new JFrame("GAME 2048");
        f.setLocation(ss.width  / 2 - 250, ss.height / 8);

        f.setJMenuBar(mb);
        f.setSize(430, 730);
        f.setResizable(false);
        f.setVisible(true);
        f.setBackground(Color.DARK_GRAY);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

