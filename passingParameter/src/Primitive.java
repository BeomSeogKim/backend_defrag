public class Primitive {

    public static void main(String[] args) {
        int x = 5;
        int y = 10;
        print("[before]",x, y);
        swap(x, y);
        print("[after]",x, y);
    }

    private static void swap(int newX, int newY) {
        int temp = newY;
        newY = newX;
        newX = temp;
        print("[swap]", newX, newY);
    }

    private static void print(String status, int x, int y) {
        System.out.println(status + " x: " + x + ", y : " + y);
    }
}
