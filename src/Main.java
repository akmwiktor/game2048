import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Field field = new Field();
        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        JMenuBar menuBar = new JMenuBar();

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

        menuBar.add(menuFile);
        menuBar.add(help);
        aboutGame.addActionListener(ActionEvent -> {
            JDialog dialog = new Help();
            dialog.setVisible(true);
        });
        exit.addActionListener(ActionEvent -> System.exit(0));

        JFrame f = new JFrame("GAME 2048");
        f.setLocation(screenSize.width  / 2 - 250, screenSize.height / 8);
        f.add(field);
        f.setJMenuBar(menuBar);
        f.setSize(430, 730);
        f.setResizable(false);
        f.setVisible(true);
        f.setBackground(Color.DARK_GRAY);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

