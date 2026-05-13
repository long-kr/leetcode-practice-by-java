package solution;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormat {

    public static void currencyFomat(double payment) {

        // Create Custome Locale for India
        Locale indiaLocale = new Locale("en", "IN");

        // Write your code here.
        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println("US: " + us.format(payment));
        System.out.println("India: " + india.format(payment));
        System.out.println("China: " + china.format(payment));
        System.out.println("France: " + france.format(payment));
    }
}
