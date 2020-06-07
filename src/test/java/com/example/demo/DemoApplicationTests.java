package com.example.demo;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)

public class DemoApplicationTests {

    @Autowired
    private CustomerService customerService;

    @Test
    void contextLoads() {
    }

    @Test
    void testRegularCalculateBillAmount() {
        System.out.println("testRegularCalculateBillAmount");
        Customer customer = new Customer("ABC", "regular", new BigDecimal(15000));
        Customer result = customerService.calculateBillAmount(customer);
        assertEquals(result.getBillAmount(), new BigDecimal(13500));
    }
    @Test
    void testPremiumCalculateBillAmount() {
        System.out.println("testPremiumCalculateBillAmount");
        Customer customer = new Customer("ABC", "premium", new BigDecimal(20000));
        Customer result = customerService.calculateBillAmount(customer);
        assertEquals(result.getBillAmount(), new BigDecimal(15800));
    }
}
