import flowers.Flower;
import flowers.FlowerBucket;
import flowers.FlowerPack;
import flowers.FlowerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlowersStoreTest {
    private FlowerBucket bucket1, bucket2, bucket3;
    private FlowersStore store;

    @BeforeEach
    void setUp() {
        bucket1 = new FlowerBucket();
        Flower flower = new Flower(FlowerType.TULIP, "pink", 7.9, 42.25);
        FlowerPack pack = new FlowerPack(flower, 10);
        bucket1.addFlowerPack(pack);
        flower = new Flower(FlowerType.CHAMOMILE, "while", 14.7, 68.);
        pack = new FlowerPack(flower, 2);
        bucket1.addFlowerPack(pack);
        // price = 558.5

        bucket2 = new FlowerBucket();
        flower = new Flower(FlowerType.ROSE, "red", 64.7, 88.8);
        pack = new FlowerPack(flower, 7);
        bucket2.addFlowerPack(pack);
        // price = 621.6

        bucket3 = new FlowerBucket();
        flower = new Flower(FlowerType.CHAMOMILE, "red", 17, 100.99);
        pack = new FlowerPack(flower, 5);
        bucket3.addFlowerPack(pack);
        flower = new Flower(FlowerType.CHAMOMILE, "red", 22, 33.);
        pack = new FlowerPack(flower, 20);
        bucket3.addFlowerPack(pack);
        // price = 1164.95

        store = new FlowersStore();
    }

    @Test
    void search() {
        assertEquals(store.search(10_000), new ArrayList<>());
        store.addBucket(bucket1);
        store.addBucket(bucket2);
        assertEquals(store.search(600), new ArrayList<>(Arrays.asList(bucket1)));
        assertEquals(store.search(700), new ArrayList<>(Arrays.asList(bucket1, bucket2)));
        store.addBucket(bucket1);
        store.addBucket(bucket3);
        assertEquals(store.search(600), new ArrayList<>(Arrays.asList(bucket1, bucket1)));
        assertEquals(store.search(1200), new ArrayList<>(Arrays.asList(bucket1, bucket2, bucket1, bucket3)));
    }

    @Test
    void addBucket() {
        assertEquals(store.getBuckets().size(), 0);
        store.addBucket(bucket2);
        assertEquals(store.getBuckets().size(), 1);
        assertEquals(store.getBuckets().get(0).getPrice(), 621.6);
    }
}