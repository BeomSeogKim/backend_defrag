package overriding;

import jdk.jshell.spi.ExecutionControlProvider;

import java.io.IOException;

public class Pointer3D extends Pointer2D {

    int x;
    int y;
    int z;

    public Pointer3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    @Override
    public String locate() throws IOException {
        return "x : " + x + ", y : " + y + ", z : " + z;
    }

    /*
    부모 Class 보다 좁은 접근 제어자는 불가능 하다.
     */
//    @Override
//    protected String locate() throws IOException {
//        return "x : " + x + ", y : " + y + ", z : " + z;
//    }

    /*
    부모 클래스 보다 더 많은 예외를 던질 수 없다.
     */
//    @Override
//    public String locate() throws Exception {
//        return "x : " + x + ", y : " + y + ", z : " + z;
//    }
}
