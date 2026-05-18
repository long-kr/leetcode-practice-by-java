package solution;

import java.math.BigInteger;

// Hackerrank

public class PrimeNumberCheck {

    public static void isPrimeNumber(String s) throws NumberFormatException {

        BigInteger num = new BigInteger(s);

        if (num.isProbablePrime(10)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }

}
