package payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardPaymentStrategyTest {
    PaymentStrategy paymentStrategy = new CreditCardPaymentStrategy();

    @Test
    void pay() {
        assertEquals(paymentStrategy.getBalance(), 0.);
        assertFalse(paymentStrategy.pay(10.));
        paymentStrategy.setBalance(5.);
        assertEquals(paymentStrategy.getBalance(), 5.);
        assertFalse(paymentStrategy.pay(10.));
        paymentStrategy.addToBalance(-2);
        assertEquals(paymentStrategy.getBalance(), 5.);
        paymentStrategy.addToBalance(12.);
        assertEquals(paymentStrategy.getBalance(), 17.);
        assertTrue(paymentStrategy.pay(10.));
        assertEquals(paymentStrategy.getBalance(), 7.);
    }

}
