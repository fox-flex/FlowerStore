package flowers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerPackTest {
    private Flower flower;
    private FlowerPack pack;

    @BeforeEach
    void setUp() {
        flower = new Flower(FlowerType.TULIP, "pink", 7.9, 42.25);
        pack = new FlowerPack(flower, 10);
    }

    @Test
    void getPrice() {
        assertEquals(pack.getPrice(), 422.5);
        flower.setColor("purple");
        assertEquals(pack.getPrice(), 422.5);
        flower.setPrice(22.22);
        assertEquals(pack.getPrice(), 222.2);
        pack.setAmount(5);
        assertEquals(pack.getPrice(), 111.1);
    }
}