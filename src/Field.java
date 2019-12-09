import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Field extends JPanel implements Runnable, ActionListener {

    Timer mTimer = new Timer(20, this);

    private int[] textX = {48, 144, 240, 336}; // step 96
    private int[] textY = {214, 308, 402, 496}; // step 94
    private int blockX[]  = {0, 98, 194, 290, 386}; // step 96
    private int blockY[] = {150, 245, 340, 435, 530}; // step 94

    public Field() {
        mTimer.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }
    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {

        }
        public void keyReleased(KeyEvent e) {

        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }
    @Override
    public void run() {

    }
    public void paint(Graphics g) {
//        int l = (int)(System.currentTimeMillis() / 30 % 120);
        g = (Graphics2D) g;
        g.setColor(Color.getHSBColor(.0f, .0f, .9f));
        g.fillRect(0,0,430,730);

        g.setColor(Color.getHSBColor(.0f, .0f, .7f));
        g.fillRect(20,120,190,100);
        g.fillRect(220,120,190,100);
        g.fillRect(20,230,390,385);

        g.setColor(Color.DARK_GRAY);
        Font font = new Font("Arial", Font.BOLD, 80);
        g.setFont(font);
        g.drawString("2048", 100,80);
        font = new Font("Courier", Font.BOLD, 32);
        g.setFont(font);
        g.drawString("SCORE", 60, 150);
        g.drawString("BEST", 268, 150);
    }
}