package Dynamic.step2;

import java.util.Scanner;

public class baekjoon1509 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();

        int n = s.length();
        s = " " + s;

        boolean[][] c = new boolean[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            c[i][i] = true;
        }
        for (int i = 1; i <= n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                c[i][i+1] = true;
            }
        }

        for (int k = 2; k < n; k++) {
            for (int i = 1; i <= n-k; i++) {
                int j = i+k;

                if (s.charAt(i) == s.charAt(j) && c[i+1][j-1]) {
                    c[i][j] = true;
                }
            }
        }
        int[] d = new int[n+1];

        for (int i = 1; i <= n; i++) {
            d[i] = -1;
            for (int j = 1; j <= i; j++) {
                if (c[j][i]) {
                    if (d[i] == -1 || d[i] > d[j-1] + 1) {
                        d[i] = d[j - 1] + 1;
                    }
                }
            }
        }
        System.out.println(d[n]);
    }
}
