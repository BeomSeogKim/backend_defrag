package overriding;

import java.io.IOException;

public class Pointer2D {
    int x;
    int y;

    public Pointer2D() {
    }

    public Pointer2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String locate() throws IOException, IllegalArgumentException {
        return "x : " + x + ", y : " + y;
    }
}
