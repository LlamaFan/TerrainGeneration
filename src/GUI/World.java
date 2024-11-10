package GUI;

import javax.swing.*;
import java.awt.*;

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

        for (int i = 0; i < squares; i++)
            for (int j = 0; j < squares; j++) {
                if (terrain[i][j] == 0) {
                    g.setColor(Color.black);
                } else {
                    g.setColor(Color.white);
                }

                g.drawRect(j * length, i * length, length, length);
            }

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
            if ((int) Math.round(function(i)) >= squares) {
                terrain[i][squares - 1] = 1;
            } else if ((int) Math.round(function(i)) <= 0) {
                terrain[i][0] = 1;
            } else {
                terrain[i][(int) Math.round(function(i))] = 1;
            }
        }
    }

    // This method makes the mathematical function

    private double function(double x) {
        return Math.sin(x);
    }
}