package delivery;

import items.Item;
import items.Koktus;
import items.flowers.Flower;
import items.flowers.FlowerBucket;
import items.flowers.FlowerPack;
import items.flowers.FlowerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import payment.PayPalPaymentStrategy;
import payment.PaymentStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DHLDeliveryStrategyTest {
    List<Item> items = new ArrayList<>();
    Item koktus;
    DeliveryStrategy dhl = new DHLDeliveryStrategy();

    @BeforeEach
    void setUp() {
        items.clear();
        koktus = new Koktus(10);
        koktus.setDescription("AAA KOKTUS!!!");
        items.add(koktus);
        Flower rose = new Flower(FlowerType.ROSE, "red", 10.,70);
        Flower tulip = new Flower(FlowerType.TULIP, "white", 7.,79);
        FlowerPack rosePuck = new FlowerPack(rose,3);
        FlowerPack tulipPuck = new FlowerPack(tulip, 4);
        Item bucket = new FlowerBucket(new ArrayList<>(Arrays.asList(rosePuck, tulipPuck)));
        items.add(bucket);
    }

    @Test
    void deliverPrice() {
        double a = dhl.deliverPrice(items); //5.
        assertEquals(dhl.deliverPrice(items), 5.);
        items.add(koktus);
        double b = dhl.deliverPrice(items); //5.
        assertEquals(dhl.deliverPrice(items), 5.);
        System.out.println(dhl.deliverPrice(items));
        dhl.setFastDelivery(true);
        double c = dhl.deliverPrice(items); //12.5
        assertEquals(dhl.deliverPrice(items), 12.5);
        dhl.setFragileProductDelivery(true);
        double d = dhl.deliverPrice(items); //12.5
        assertEquals(dhl.deliverPrice(items), 22.5);
    }

    @Test
    void deliver() {
        PaymentStrategy paymentStrategy = new PayPalPaymentStrategy();
        assertEquals(dhl.deliverPrice(items), 5.);
        assertEquals(paymentStrategy.getBalance(), 0.);
        assertFalse(dhl.deliver(items, paymentStrategy.pay(dhl.deliverPrice(items))));
        paymentStrategy.setBalance(30.);
        assertTrue(dhl.deliver(items, paymentStrategy.pay(dhl.deliverPrice(items))));
    }
}
