package decorators;

import items.Koktus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RibbonDecoratorTest {
    ItemDecorator decorated;

    @BeforeEach
    void setUp() {
        decorated = new RibbonDecorator(new Koktus(999.9, "Cool stuff :=)"));
    }

    @Test
    void getPrice() {
        assertEquals(decorated.getPrice(), 999.9+39);
    }

    @Test
    void getDescription() {
        assertEquals(decorated.getDescription(), "Cool stuff :=)" + " Ribbon decorated.");
    }
}
