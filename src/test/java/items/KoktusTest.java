package items;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KoktusTest {
    static Item koktus;

    @BeforeEach
    void setUp() {
        koktus = new Koktus();
        koktus.setDescription("AAA KOKTUS!!!");
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals(koktus.getPrice(), 100_000);
        koktus = new Koktus(2_0_0_0_0_0_0);
        assertEquals(koktus.getPrice(), 2000000);
    }
    @Test
    void getDescription() {
        assertEquals(koktus.getDescription(), "AAA KOKTUS!!!");
    }
}
