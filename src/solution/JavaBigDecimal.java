package solution;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JavaBigDecimal {
    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];

        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        // Write your code here
        Arrays.sort(s, 0, n, new Comparator<String>() {

            @Override
            public int compare(String a, String b) {
                BigDecimal numA = new BigDecimal(a);
                BigDecimal numB = new BigDecimal(b);

                return numB.compareTo(numA);
            }
        });

        for (

                int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }
}
