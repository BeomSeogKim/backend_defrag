package overloading;

public class Printer {

    public static void main(String[] args) {
        Printer printer = new Printer();
        System.out.println(printer.print("tommy"));
        System.out.println(printer.print("tommy", 2));
    }

    public String print(String name) {
        return "이름 : " + name;
    }
    public String print(String name, int age) {
        return "이름 : " + name + ", age : " + age;
    }

    /*
    메서드 중복으로 인한 compile error 발생
     */
//    public int print(String name, int age) {
//        return age;
//    }

}
