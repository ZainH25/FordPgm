import java.io.*;

public class FordPgm {
    public static void main(String[] args) throws IOException {
        int i, j, m, k, x, y, min, n;
        int[][] a = new int[10][10];
        int[][] h = new int[10][10];
        DataInputStream in = new DataInputStream(System.in);

        System.out.println("Enter number of nodes!");
        n = Integer.parseInt(in.readLine());

        System.out.println("Enter Distance Matrix");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                a[i][j] = Integer.parseInt(in.readLine());
                h[i][j] = 0;
            }
        }

        /* - calculate the hop for the nodes */
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                if (a[i][j] != 0 && a[i][j] != 999) {
                    h[i][j] = 1;
                }
            }
        }

        /* - display the node details */
        for (i = 1; i <= n; i++) {
            System.out.println("The routing table for " + i + "th node is");
            System.out.println("NODE\tDISTANCE\tHOPS");
            for (j = 1; j <= n; j++) {
                System.out.println(" " + j + "\t" + a[i][j] + "\t" + h[i][j]);
            }
        }

        System.out.println("After calculation of path");
        for (m = 1; m <= n; m++) {
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    min = a[i][j];
                    for (k = 1; k <= n; k++) {
                        if (min > a[i][k] + a[k][j]) {
                            a[i][j] = a[i][k] + a[k][j];
                            h[i][j] = h[i][k] + h[k][j];
                        }
                    }
                }
            }
        }

        for (i = 1; i <= n; i++) {
            System.out.println("The routing table for " + i + "th node is");
            System.out.println("NODE\tDISTANCE\tHOPS");
            for (j = 1; j <= n; j++) {
                System.out.println(" " + j + "\t" + a[i][j] + "\t" + h[i][j]);
            }
            System.out.println();
        }

        System.out.println("Enter the node whose shortest path is to be found");
        System.out.println(" From ");
        x = Integer.parseInt(in.readLine());
        System.out.println(" To ");
        y = Integer.parseInt(in.readLine());
        System.out.println("Shortest Path is " + a[x][y] + " with " + h[x][y] + " Hops.");
    }
}