package GUI;

import javax.swing.*;

public class Window extends JFrame implements Runnable {
    public boolean running;

    private JPanel world;

    public Window() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        int ticks = 20;

        running = true;

        while (running) {
            if (lastTime + 1000000 >= System.currentTimeMillis()) {

            }
        }
    }
}
