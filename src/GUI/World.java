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
        drawLine(g);
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
            int value = (int) function(i);

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

    private double function(double x) {
        Random r = new Random();

        double c = 1;
        double k = 2;

        double f1 = r.nextInt(10) - 10;
        double f2 = r.nextInt(10) - 10;
        double f3 = r.nextInt(10) - 10;
        double f4 = r.nextInt(10) - 10;

        double a1 = Math.random() - c / 2;
        double a2 = Math.random() - c / 2;
        double a3 = Math.random() - c / 2;
        double a4 = Math.random() - c / 2;

        double o1 = Math.random() * 10 - 6;
        double o2 = Math.random() * 10 - 6;
        double o3 = Math.random() * 10 - 6;
        double o4 = Math.random() * 10 - 6;

        double result = (a1*Math.sin(f1*(k * x + o1)) + a2*Math.sin(f2*(k * x + o2)) + a3*Math.sin(f3*(k * x + o3)) + a4*Math.sin(f2*(k * x + o4))) * 100;
        System.out.println(result);
        return result;
    }
}