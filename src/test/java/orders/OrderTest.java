package orders;

import decorators.DecorType;
import delivery.DeliveryStrategy;
import delivery.PostDeliveryStrategy;
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
import users.Receiver;
import users.Sender;
import users.User;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Item koktus, bucket;
    DeliveryStrategy post = new PostDeliveryStrategy();
    PaymentStrategy paypal = new PayPalPaymentStrategy();
    Order order;

    @BeforeEach
    void setUp() {
        order = new Order(post, paypal);
        koktus = new Koktus(10);
        koktus.setDescription("AAA KOKTUS!!!");
        Flower rose = new Flower(FlowerType.ROSE, "red", 10.,70);
        Flower tulip = new Flower(FlowerType.TULIP, "white", 7.,79);
        FlowerPack rosePuck = new FlowerPack(rose,3);
        FlowerPack tulipPuck = new FlowerPack(tulip, 4);
        bucket = new FlowerBucket(new ArrayList<>(Arrays.asList(rosePuck, tulipPuck)));
    }

    @Test
    void getPrice() {
        assertEquals(order.getPrice(), 0., 1e-5);
        order.addItem(bucket);
        assertEquals(order.getPrice(), 529.0, 1e-5);
        order.addItem(koktus);
        assertEquals(order.getPrice(), 542., 1e-5);
        order.decorateItemInIndex(1, DecorType.PAPER);
        assertEquals(order.getPrice(), 555.21, 1e-5);
        order.setFastDelivery(true);
        assertEquals(order.getPrice(), 593.61, 1e-5);
    }

    @Test
    void addItem() {
        assertEquals(order.getPrice(), 0., 1e-5);
        order.addItem(koktus);
        assertNotEquals(order.getPrice(), 0);
    }

    @Test
    void decorateItemInIndex() {
        order.addItem(koktus);
        double pricePrev = order.getPrice();
        order.decorateItemInIndex(0, DecorType.PAPER);
        assertEquals(pricePrev+13.21, order.getPrice(), 1e-5);
    }

    @Test
    void pay() {
        order.addItem(bucket);
        order.addItem(koktus);
        order.decorateItemInIndex(1, DecorType.PAPER);
        order.setFastDelivery(true);
        assertEquals(order.getPrice(), 593.61, 1e-5);
        assertEquals(order.getBalance(), 0., 1e-5);
        order.updateBalance(300.);
        assertFalse(order.pay());
        assertEquals(order.getPrice(), 593.61, 1e-5);
        order.updateBalance(300.);
        assertTrue(order.pay());
        assertEquals(order.getBalance(), 6.39, 1e-5);
        assertTrue(order.pay());
    }

    @Test
    void deliver() {
        assertFalse(order.deliver());
        order.addItem(bucket);
        order.addItem(koktus);
        order.setFastDelivery(true);
        assertFalse(order.deliver());
        assertEquals(order.getPrice(), 580.4, 1e-5);
        order.updateBalance(600.);
        assertTrue(order.pay());
        assertTrue(order.deliver());
        assertFalse(order.deliver());
    }

    @Test
    void processOrder() {
        assertFalse(order.processOrder());
        order.addItem(bucket);
        order.addItem(koktus);
        order.setFastDelivery(true);
        assertFalse(order.processOrder());
        assertEquals(order.getPrice(), 580.4, 1e-5);
        order.updateBalance(600.);
        assertTrue(order.pay());
        assertTrue(order.processOrder());
        assertTrue(order.processOrder());
    }

    @Test
    void addDelUser() {
        assertEquals(order.getUsers().size(), 0);
        User receiver = new Receiver();
        order.addUser(receiver);
        order.addUser(new Sender());
        assertEquals(order.getUsers().size(), 2);
        order.delUser(receiver);
        assertEquals(order.getUsers().size(), 1);
        order.delUser(order.getUsers().get(0));
        assertEquals(order.getUsers().size(), 0);
    }

    @Test
    void order() {

    }
}
