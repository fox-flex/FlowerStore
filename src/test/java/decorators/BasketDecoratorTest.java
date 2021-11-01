package decorators;

import items.Koktus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketDecoratorTest {
    ItemDecorator decorated;

    @BeforeEach
    void setUp() {
        decorated = new BasketDecorator(new Koktus(999.9, "Cool stuff :=)"));
    }

    @Test
    void getPrice() {
        assertEquals(decorated.getPrice(), 999.9+13);
    }

    @Test
    void getDescription() {
        assertEquals(decorated.getDescription(), "Cool stuff :=)" + " Decorated by basket.");
    }
}
