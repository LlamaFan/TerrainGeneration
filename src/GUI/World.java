package GUI;

import javax.swing.*;
import java.awt.*;

public class World extends JPanel {
    private final int sizeX = 500;
    private final int sizeY = 500;

    private DrawTerrain drawTerrain;

    public World() {
        drawTerrain = new DrawTerrain();

        setPreferredSize(new Dimension(sizeX, sizeY));
        setBackground(Color.BLACK);
    }

    public void repaint() {
        super.repaint();
    }
}
