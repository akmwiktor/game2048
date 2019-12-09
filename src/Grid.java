import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.stream.IntStream;

public class Grid {

    private int [][] startGrid = new int[4][4];
    private int [][] gameGrid = new int[4][4];
    private int[][] previosGrid = new int[4][4];
    String[][] stringGrid = new String[4][4];
    int best = 0;
    int score = 0;
    private int p = 0;
    boolean add = false;
    Random rnd = new Random(System.currentTimeMillis());

    public void newGame() {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                gameGrid[i][j] = startGrid[i][j];
            }
        score = 0;
        add();
        add();
    }

    public String[][] convertTosString() {
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                if (gameGrid[i][j] < 1) stringGrid[i][j] = "";
                else stringGrid[i][j] = gameGrid[i][j] + "";
            }
        return stringGrid;
    }
    private void moveY(int step) {
        for (int x = 0; x < 4; x++) {
            for (int y = step < 0 ? 3 : 0; y >= 0 && y <= 3; y += step) {
                checkToMergeY(x, step);
                if (y + step > 3 || y + step < 0) break;
                if (this.gameGrid[y][x] != this.gameGrid[y + step][x]) continue;
                this.gameGrid[y][x] += this.gameGrid[y + step][x];
                this.gameGrid[y + step][x] = 0;
            }
        }
    }
    private void checkToMergeY(int x, int indY) {
        for (int y = indY == 1 ? 0 : 3; y >= 0 && y <= 3; y += indY) {
            if (this.gameGrid[y][x] != 0) continue;
            for (int t = y + indY; t >= 0 && t <= 3; t += indY) {
                if (this.gameGrid[t][x] != 0) {
                    this.gameGrid[y][x] = this.gameGrid[t][x];
                    this.gameGrid[t][x] = 0;
                    break;
                }
            }
        }
    }
    private void moveX(int indX) {
        for (int y = 0; y < 4; y++) {
            if (IntStream.of(this.gameGrid[y]).sum() == 0) continue;
            for (int x = indX == -1 ? 3 : 0; x >= 0 && x <= 3; x += indX) {
                checkToMergeX(this.gameGrid[y], x, indX);
                if (x + indX > 3 || x + indX < 0) break;
                if (this.gameGrid[y][x] != this.gameGrid[y][x + indX]) continue;
                this.gameGrid[y][x] += this.gameGrid[y][x + indX];
                this.gameGrid[y][x + indX] = 0;
            }
        }
    }
    private void checkToMergeX(int[] grid, int x, int indX) {
        for (; x >= 0 && x <= 3; x += indX) {
            if (grid[x] != 0) continue;
            for (int t = x + indX; t >= 0 && t <= 3; t += indX) {
                if (grid[t] != 0) {
                    grid[x] = grid[t];
                    grid[t] = 0;
                    break;
                }
            }
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_RIGHT){
            moveX(-1);
            add();
        }
        if (key == KeyEvent.VK_LEFT){
            moveX(1);
            add();
        }
        if (key == KeyEvent.VK_UP){
            moveY(1);
            add();
        }
        if (key == KeyEvent.VK_DOWN){
            moveY(-1);
            add();
        }
        if (key == KeyEvent.VK_E){
            System.exit(0);
        }
        if (key == KeyEvent.VK_N){
            newGame();
        }
        if (key == KeyEvent.VK_H){
            JDialog dialog = new Help();
            dialog.setVisible(true);;
        }
    }
    private void add() {
        int s = rnd.nextInt(10);
        int n = s  < 9 ? 2 : 4;
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                if (previosGrid[i][j] != this.gameGrid[i][j] || score < 8) {
                    previosGrid[i][j] = this.gameGrid[i][j];
                    add = true;
                }
            }
        }
        if (!add) return;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                if (this.gameGrid[(s + i) % 4][(s + j) % 4] == 0) {
                    this.gameGrid[(s + i) % 4][(s + j) % 4] = n;
                    previosGrid[(s + i) % 4][(s + j) % 4] = n;
                    score += n;
                    if (best < score) best = score;
                    add = false;
                    return;
                }
    }
    public void keyPressed(KeyEvent e) {
    }
}