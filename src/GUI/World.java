package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class World extends JPanel {
    private final int size = 500;
    private final int squares = 100;
    private final int length = size / squares;

    private final int seed = 9843;

    private int[][] terrain;

    public World() {
        terrain = new int[squares][squares];

        for (int i = 0; i < squares; i++)
            for (int j = 0; j < squares; j++)
                terrain[i][j] = 0;

        setPreferredSize(new Dimension(size, size));
        setBackground(Color.BLACK);

        convert();
    }

    // Repaints the world

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < squares; i++)
            for (int j = 0; j < squares; j++) {
                if (terrain[i][j] == 0) {
                    g2.setColor(Color.black);
                } else {
                    g2.setColor(Color.white);
                }

                g2.fillRect(i * length, j * length, length, length);
            }

        g.setColor(Color.darkGray);
        //drawLine(g);
        g.dispose();
    }

    private void drawLine(Graphics g) {
        for (int i = 0; i < squares; i++) {
            g.drawLine(i * length, 0, i * length, size);
            g.drawLine(0, i * length, size, i * length);
        }
    }

    // Here the terrain will be generated
    // The method will convert the mathematical function into the array

    private void convert() {
        for (int i = 0; i < squares; i++) {
            int value = (int) function2(i);

            if (value >= squares) {
                terrain[i][squares - 1] = 1;
            } else if (value <= 0) {
                terrain[i][0] = 1;
            } else {
                terrain[i][value] = 1;
            }
        }
    }

    // This method makes the mathematical function

    private double function2(int x) {
        return Math.sin(x / 10) * 10 + squares / 2;
    }

    private double function(double x) {
        Random r = new Random();

        double c = 1;
        double k = 1;

        double f1 = r.nextDouble(10);
        double f2 = r.nextDouble(10);
        double f3 = r.nextDouble(10);
        double f4 = r.nextDouble(10);

        double a1 = r.nextDouble((c/f1)) - (c/f1);
        double a2 = r.nextDouble((c/f1)) - (c/f1);
        double a3 = r.nextDouble((c/f1)) - (c/f1);
        double a4 = r.nextDouble((c/f1)) - (c/f1);

        double o1 = r.nextDouble(6.28);
        double o2 = r.nextDouble(6.28);
        double o3 = r.nextDouble(6.28);
        double o4 = r.nextDouble(6.28);

        double result = (
            a1 * Math.sin(f1 * (k * (x / squares) + o1)) +
            a2 * Math.sin(f2 * (k * (x / squares) + o2)) +
            a3 * Math.sin(f3 * (k * (x / squares) + o3)) +
            a4 * Math.sin(f4 * (k * (x / squares) + o4))) * squares + squares / 2;
        System.out.println(result);
        return result;
    }
}