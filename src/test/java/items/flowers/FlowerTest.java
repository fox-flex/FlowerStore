package items.flowers;

import static org.junit.jupiter.api.Assertions.*;

class FlowerTest {
    private Flower flower;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        flower = new Flower(FlowerType.CHAMOMILE);
        flower.setPrice(29.99);
        flower.setColor("white");
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals(flower.getPrice(), 29.99);
    }

    @org.junit.jupiter.api.Test
    void getColor() {
        assertEquals(flower.getColor(), "white");
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        flower.setColor("brr");
        assertEquals(flower.getColor(), "none");
        flower.setColor("yellow");
        assertEquals(flower.getColor(), "yellow");
    }

    @org.junit.jupiter.api.Test
    void setFlowerType() {
        flower.setFlowerType(FlowerType.ROSE);
        assertEquals(flower.getColor(), "none");
        assertEquals(flower.getPrice(), 0.);
        assertEquals(flower.getSepalLength(), 0.);
        assertEquals(flower.getFlowerType(), FlowerType.ROSE);
    }
}
