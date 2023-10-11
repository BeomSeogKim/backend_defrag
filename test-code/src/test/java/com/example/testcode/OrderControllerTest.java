package com.example.testcode;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = OrderController.class)
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    OrderService orderService;


    @DisplayName("주문을 저장한다.")
    @Test
    void save() throws Exception {
        // given
        OrderWebRequest orderWebRequest = new OrderWebRequest(10000);

        // when && then
        mockMvc.perform(
                post("/orders")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(orderWebRequest))
        )
                .andExpect(status().isOk());

    }

    @DisplayName("주문저장 시 가격이 음수라면 예외가 발생한다.")
    @Test
    void save_invalidPrice() throws Exception {
        // given
        OrderWebRequest orderWebRequest = new OrderWebRequest(-10000);

        // when && then
        mockMvc.perform(
                        post("/orders")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(orderWebRequest))
                )
                .andExpect(status().isBadRequest())
                ;

    }
}
