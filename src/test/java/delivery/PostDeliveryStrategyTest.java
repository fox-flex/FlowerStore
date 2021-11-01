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

class PostDeliveryStrategyTest {
    List<Item> items = new ArrayList<>();
    Item koktus;
    DeliveryStrategy post = new PostDeliveryStrategy();

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
        double a = post.deliverPrice(items);
        assertEquals(post.deliverPrice(items), 3.);
        items.add(koktus);
        double b = post.deliverPrice(items);
        assertEquals(post.deliverPrice(items), 3.);
        System.out.println(post.deliverPrice(items));
        post.setFastDelivery(true);
        double c = post.deliverPrice(items);
        assertEquals(post.deliverPrice(items), 22.2);
        post.setFragileProductDelivery(true);
        double d = post.deliverPrice(items);
        assertEquals(post.deliverPrice(items), 36.4);
    }

    @Test
    void deliver() {
        PaymentStrategy paymentStrategy = new PayPalPaymentStrategy();
        assertEquals(post.deliverPrice(items), 3.);
        assertEquals(paymentStrategy.getBalance(), 0.);
        assertFalse(post.deliver(items, paymentStrategy));
        paymentStrategy.setBalance(10000000.);
        assertTrue(post.deliver(items, paymentStrategy));
    }
}
