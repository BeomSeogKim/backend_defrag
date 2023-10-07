package simple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Test
    void manualTest() {
        Cart cart = new Cart();
        cart.add("Onion");
        cart.add("Apple");

        System.out.println("카트에 담긴 물품 수 : " + cart.getCartList().size());
        System.out.println("카트 물품 목록 : " + getList(cart.getCartList()));
    }

    private String getList(List<String> cartList) {
        StringBuilder sb = new StringBuilder();
        cartList.forEach(
                c -> sb.append(c + ", ")
        );
        return sb.toString();
    }

    @Test
    void autoTest() {
        Cart cart = new Cart();
        cart.add("Onion");
        cart.add("Apple");

        List<String> cartList = cart.getCartList();
        Assertions.assertThat(cartList).hasSize(2)
                .containsExactlyInAnyOrder("Onion", "Apple");
    }
}
