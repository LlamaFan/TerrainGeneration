package GUI;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame implements Runnable {
    public boolean running;

    private World world;

    public Window() {
        world = new World();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Terrain Generation");
        setResizable(false);

        add(world);
        pack();

        setVisible(true);
        run();
    }

    @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        int ticks = 5;

        running = true;

        while (running) {
            if (System.currentTimeMillis() >= lastTime + 1000 / ticks) {
                world.repaint();
                lastTime = System.currentTimeMillis();
            }
        }
    }
}
