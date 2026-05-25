package solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HourGlass {
    public static void hourglassSum() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();

        int result = Integer.MIN_VALUE;

        for (int i = 0; i + 2 < arr.size(); i++) {
            List<Integer> top = arr.get(i);
            List<Integer> mid = arr.get(i + 1);
            List<Integer> bot = arr.get(i + 2);

            for (int j = 0; j + 2 < top.size(); j++) {
                int sum = 0;
                sum += (top.get(j) + top.get(j + 1) + top.get(j + 2));
                sum += mid.get(j + 1);
                sum += (bot.get(j) + bot.get(j + 1) + bot.get(j + 2));

                result = Math.max(result, sum);
            }
        }

        System.out.println(result);
    }
}
