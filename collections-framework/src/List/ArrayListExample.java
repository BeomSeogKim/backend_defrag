package List;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        // initial Capacity => 초기 용량 지정
        ArrayList<Object> list = new ArrayList<>(10);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        // ArrayList 생성자에 Collection이 들어가도 된다.
        ArrayList<Object> list2 = new ArrayList<>(list.subList(1, 4));

        print(list, list2);

        /*
        모든 요소를 포함하고 있는지 확인하는 메서드
        true : 모든 요소 포함 // false : 모든 요소가 포함되지는 않음
         */
        System.out.println("list.containsAll(list2) : " + list.containsAll(list2));
        System.out.println();

        // 원하는 index에 값을 추가하는 메서드
        list2.add(3, "A");
        print(list, list2);
        // 원하는 index에 값을 변경하는 메서드
        list2.set(3, "AA");
        print(list, list2);

        /*
         retainAll : 공통 부분만 남기고 나머지는 삭제
         변화가 있을 경우 : true // 변화가 없을 경우 : false
         */
        System.out.println("list.retainAll(list2) : " + list.retainAll(list2));
        System.out.println();
        print(list, list2);


    }

    private static void print(ArrayList<Object> list, ArrayList<Object> list2) {
        System.out.println("list : " + list);
        System.out.println("list2 : " + list2);
        System.out.println();
    }
}
