public class NonPrimitive {
    public static void main(String[] args) {
        CustomNumber a = new CustomNumber(5);
        CustomNumber b = new CustomNumber(10);
        print("[before]", a.getNumber(), b.getNumber());
        swap(a, b);
        print("[after]", a.getNumber(), b.getNumber());
    }

    private static void swap(CustomNumber a1, CustomNumber b1) {
        a1.number++;

        b1 = new CustomNumber(10);
        b1.number++;
        print("[swap]", a1.getNumber(), b1.getNumber());
    }
    private static void print(String status, int a, int b) {
        System.out.println(status + " a: " + a + ", b : " + b);
    }

    private static class CustomNumber {
        private int number;
        public CustomNumber(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }
}
