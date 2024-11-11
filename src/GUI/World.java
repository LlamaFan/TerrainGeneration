package GUI;

import Terrain.Terrain;

import javax.swing.*;
import java.awt.*;

public class World extends JPanel {
    private final int size = 500;
    private final int squares = 500;
    private final int length = size / squares;

    private Terrain terrain;

    public World() {
        setPreferredSize(new Dimension(size, size));
        setBackground(Color.BLACK);

        terrain = new Terrain(squares);
        terrain.initTerrain();
    }

    // Repaints the world

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i < squares; i++)
            for (int j = 0; j < squares; j++) {
                if (terrain.getTerrain()[i][j] == 0) {
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
}