import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class MyEnumMap {
    public static void main(String[] args) {
        EnumMap<Days, String> enumMap = new EnumMap<>(Days.class);
        init(enumMap);
        HashMap<Days, String> hashMap = new HashMap<>();
        init(hashMap);
        System.out.println("<< Hash Map >>");
        calculate(hashMap);
        System.out.println("<< Enum Map >>");
        calculate(enumMap);
    }

    private static void init(Map<Days, String> map) {
        map.put(Days.MONDAY, "Monday");
        map.put(Days.TUESDAY, "Tuesday");
        map.put(Days.WEDNESDAY, "Wednesday");
        map.put(Days.THURSDAY, "Thursday");
        map.put(Days.FRIDAY, "Friday");
        map.put(Days.SATURDAY, "Saturday");
        map.put(Days.SUNDAY, "Sunday");
    }

    private static void calculate(Map<Days, String> map) {
        long[] testCase = new long[100];

        for (int i = 0; i < testCase.length; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < 10_000_000; j++) {
                map.get(Days.MONDAY);
            }
            long endTime = System.nanoTime();
            testCase[i] = endTime - startTime;
        }

        long sum = 0;
        for (final long l : testCase) {
            sum += l;
        }
        System.out.println(sum / testCase.length);
    }

    enum Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}
