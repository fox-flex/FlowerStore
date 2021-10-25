package flowers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlowerBucketTest {
    private FlowerPack pack1, pack2;
    private FlowerBucket bucket;

    @BeforeEach
    void setUp() {
        Flower flower = new Flower(FlowerType.TULIP, "pink", 7.9, 42.25);
        pack1 = new FlowerPack(flower, 10);
        flower = new Flower(FlowerType.CHAMOMILE, "while", 14.7, 68.);
        pack2 = new FlowerPack(flower, 10);
        bucket = new FlowerBucket();
    }

    @Test
    void addFlowerPack() {
        assertEquals(bucket.getFlowerPacks().size(), 0);
        bucket.addFlowerPack(pack1);
        assertEquals(bucket.getFlowerPacks().get(0).getFlower().getFlowerType(), FlowerType.TULIP);
        bucket.addFlowerPack(pack2);
        assertEquals(bucket.getFlowerPacks().size(), 2);
    }

    @Test
    void getPrice() {
        assertEquals(bucket.getPrice(), 0.);
        bucket.addFlowerPack(pack2);
        assertEquals(bucket.getPrice(), 680);
        bucket.addFlowerPack(pack1);
        assertEquals(bucket.getPrice(), 1102.5);
    }
}