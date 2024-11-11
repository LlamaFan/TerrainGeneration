package Terrain;

import java.util.Random;

public class Terrain {
    private final int squares;

    private int[] seed = {
        9, 4, 5, 1, 4, 6, 8, 2, 6, 7
    };

    private int[][] terrain;

    double[] a;
    double[] b;
    double[] c;

    double[] aa;

    double h;
    double s;
    int sins;
    int sqau;

    public Terrain(int squares) {
        this.squares = squares;

        terrain = new int[squares][squares];

        for (int i = 0; i < squares; i++)
            for (int j = 0; j < squares; j++)
                terrain[i][j] = 0;
    }

    // Here the other classes will be able to get the terrain

    public void initTerrain() {
        convert();
    }

    public int[][] getTerrain() {
        return terrain;
    }

    // Here the terrain will be generated
    // The method will convert the mathematical function into the array

    private void convert() {
        initSins(500);

        for (int i = 0; i < squares; i++) {
            int value = (int) Math.round(function(i, 100)); // Range > 100 looks the best

            if (value >= squares) {
                terrain[i][squares - 1] = 1;
            } else if (value <= 0) {
                terrain[i][0] = 1;
            } else {
                terrain[i][value] = 1;
            }
        }
    }

    // This method will initialize all the arrays and set certain values;

    private void initSins(double height) {
        h = height; // Max height
        s = 0.7; // Stretch of the function

        sins = 10;
        Random r = new Random();

        a = new double[sins];
        b = new double[sins];
        c = new double[sins];

        for (int i = 0; i < sins; i++)
            a[i] = r.nextDouble(2 * h) - h;

        for (int i = 0; i < sins; i++)
            b[i] = r.nextDouble(10);

        for (int i = 0; i < sins; i++)
            c[i] = r.nextDouble(6.28);
    }

    private void initSqua() {

    }

    // This method makes the mathematical function

    private double function(double x, double range) {
        double result = 0;
        for (int i = 0; i < sins; i++)
            result += a[i] * Math.sin(b[i] * (s * (x / range) + c[i]));

        result = result / sins + (double) squares / 2;
        return result;
    }

    // This will generate a new random seed

    private void newSeed() {
        Random r = new Random();

        for (int i = 0; i < seed.length; i++)
            seed[i] = r.nextInt(20) - 10;
    }
}
