import java.util.HashMap;
import java.util.Collections;
import java.util.Map;

public class GradingApp {

    public static void main(String[] args) {
        HashMap<String, Integer> grades = new HashMap<String, Integer>();
        grades.put("Toni", 87);
        grades.put("Bryan", 90);
        grades.put("Chris", 80);
        grades.put("Shelby", 100);
        grades.put("Alex", 95);
        grades.put("Tyler", 70);
        grades.put("Erin", 65);
        grades.put("Ben", 100);
        grades.put("Tiffany", 72);
        grades.put("Sarah", 56);

        Map.Entry<String, Integer> highest = Collections.max(grades.entrySet(), Map.Entry.comparingByValue());
        Map.Entry<String, Integer> lowest = Collections.min(grades.entrySet(), Map.Entry.comparingByValue());

        double avg = grades.values().stream().mapToInt(x -> x).average().orElse(Double.NaN);
        long numA = grades.values().stream()
            .filter(g -> g >= 90)
            .count();
        long numB = grades.values().stream()
            .filter(g -> g >= 80 && g <= 89)
            .count();
        long numC = grades.values().stream()
            .filter(g -> g >= 70 && g <= 79)
            .count();
        long numFailed = grades.values().stream()
            .filter(g -> g <= 69)
            .count();

        String out = String.join(System.getProperty("line.separator"),
            String.format("highest: %d %s", highest.getValue(), highest.getKey()),
            String.format("average: %.2f", avg),
            String.format("lowest: %d %s", lowest.getValue(), lowest.getKey()),
            String.format("A: %d", numA),
            String.format("B: %d", numB),
            String.format("C: %d", numC),
            String.format("Failed: %d", numFailed),
            ""
        );
        System.out.println(out);
    }
}
