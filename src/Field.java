import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Field extends JPanel implements Runnable, ActionListener {

    Timer mTimer = new Timer(20, this);
    Grid grid = new Grid();

    private int[][][] pointBlock = {
            {{30,240}, {125,240}, {220,240}, {315,240}},
            {{30,335}, {125,335}, {220,335}, {315,335}},
            {{30,430}, {125,430}, {220,430}, {315,430}},
            {{30,525}, {125,525}, {220,525}, {315,525}},
    };

    public Field() {
        mTimer.start();
        grid.convertTosString();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }
    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            grid.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            grid.keyReleased(e);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        grid.convertTosString();
        repaint();
    }
    @Override
    public void run() {

    }
    public void paint(Graphics g) {
        String best = String.valueOf(grid.best);
        String score = String.valueOf(grid.score);

        if (grid.score < 2) grid.newGame();
        g = (Graphics2D) g;
        g.setColor(Color.getHSBColor(.0f, .0f, .80f));
        g.fillRect(0,0,430,730);

        g.setColor(Color.getHSBColor(.0f, .0f, .7f));
        g.fillRect(20,120,190,100);
        g.fillRect(220,120,190,100);
        g.fillRect(20,230,390,390);

        g.setColor(Color.DARK_GRAY);
        Font font = new Font("Arial", Font.BOLD, 80);
        g.setFont(font);
        g.drawString("2048", 100,80);
        font = new Font("Courier", Font.BOLD, 32);
        g.setFont(font);
        g.drawString("SCORE", 60, 155);
        g.drawString("BEST", 268, 155);
        g.drawString(score, 100 - score.length() * 7, 195);
        g.drawString(best, 300 - best.length() * 7, 195);
        font = new Font("Courier", Font.BOLD, 28);
        g.setFont(font);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                g.setColor(Color.getHSBColor(.0f, grid.gameGrid[i][j], .9f));
                g.fillRect(pointBlock[i][j][0], pointBlock[i][j][1], 85, 85);
                g.setColor(Color.DARK_GRAY);
                String valueCell = grid.stringGrid[i][j];
                g.drawString(valueCell, pointBlock[i][j][0] + 35 - valueCell.length() * 7,
                        pointBlock[i][j][1] + 52);
            }
        }
    }
}