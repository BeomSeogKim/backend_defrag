package simple;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {

    private List<String> cartList = new ArrayList<>();

    public void add(String product) {
        cartList.add(product);
    }

}
