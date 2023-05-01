package overriding;

public class Pointer {
    public static void main(String[] args) throws Exception {
        Pointer2D printer2D = new Pointer2D(3,5);
        Pointer3D printer3D = new Pointer3D(3, 5, 7);

        System.out.println(printer2D.locate());
        System.out.println(printer3D.locate());
    }
}

