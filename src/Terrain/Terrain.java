package Terrain;

import java.util.Random;

public class Terrain {
    private final int squares;

    private final int seed = 9843;

    private int[][] terrain;

    double[] f;
    double[] a;
    double[] o;

    double c;
    double k;
    int sins;

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
        initialize();

        for (int i = 0; i < squares; i++) {
            int value = (int) Math.round(function(i, 100, 500)); // Range > 100 looks the best

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

    private void initialize() {
        c = 1;
        k = 1;

        sins = 10;
        Random r = new Random();

        f = new double[sins];
        a = new double[sins];
        o = new double[sins];

        for (int i = 0; i < sins; i++)
            f[i] = r.nextDouble(10);

        for (int i = 0; i < sins; i++)
            a[i] = r.nextDouble((c/f[i])) - (c/f[i]);

        for (int i = 0; i < sins; i++)
            o[i] = r.nextDouble(6.28);
    }

    // This method makes the mathematical function

    private double function2(int x) {
        return Math.sin((double) x /10) * 5 + (double) squares / 2;
    }

    private double function(double x, double range, double height) {
        double result = 0;
        for (int i = 0; i < sins; i++)
            result += a[i] * Math.sin(f[i] * (k * (x / range) + o[i]));

        result = result / sins * height + (double) squares / 2;
        return result;
    }
}
