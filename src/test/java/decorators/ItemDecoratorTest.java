package decorators;

import items.Koktus;
import items.flowers.Flower;
import items.flowers.FlowerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemDecoratorTest {
    ItemDecorator decorated;

    @BeforeEach
    void setUp() {
        decorated = new ItemDecorator(new Koktus(100));
    }

    @Test
    void setSaleTest() {

        assertEquals(decorated.getSale(), 1.);
        decorated.setSale(0.4);
        assertEquals(decorated.getSale(), .4);
        decorated.setSale(10.);
        assertEquals(decorated.getSale(), .4);
    }

    @Test
    void getPriceTest() {
        assertEquals(decorated.getPrice(), 100.);
        decorated.setSale(0.5);
        assertEquals(decorated.getPrice(), 50.);
    }
}
