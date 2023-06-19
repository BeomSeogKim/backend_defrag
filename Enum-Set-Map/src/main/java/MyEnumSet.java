import java.util.*;

public class MyEnumSet {
    public static void main(String[] args) {
        EnumSet<Days> enumSet = EnumSet.allOf(Days.class);
        init(enumSet);
        HashSet<Days> hashSet = new HashSet<>();
        init(hashSet);
        System.out.println("<< Hash Set >>");
        calculate(hashSet);
        System.out.println("<< Enum Set >>");
        calculate(enumSet);
    }

    private static void init(Set<Days> set) {
        set.add(Days.MONDAY);
        set.add(Days.TUESDAY);
        set.add(Days.WEDNESDAY);
        set.add(Days.THURSDAY);
        set.add(Days.FRIDAY);
        set.add(Days.SATURDAY);
        set.add(Days.SUNDAY);
    }

    private static void calculate(Set<Days> set) {
        long[] testCase = new long[100];

        for (int i = 0; i < testCase.length; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < 10_000_000; j++) {
                set.contains(Days.MONDAY);
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
