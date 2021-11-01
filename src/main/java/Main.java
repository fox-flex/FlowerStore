import flowers.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Flower rose1 = new Flower(FlowerType.ROSE);
        Flower rose2 = new Flower(FlowerType.ROSE, "red", 5, 50);
        Flower rose3 = new Flower(FlowerType.ROSE, "aaa", 5, 50);
        Flower chamomile1 = new Flower(FlowerType.CHAMOMILE);
        Flower chamomile2 = new Flower(FlowerType.CHAMOMILE, "white", 5, 20);
        Flower chamomile3 = new Flower(FlowerType.CHAMOMILE, "flex", 1000, 50);
        Flower tulip1 = new Flower(FlowerType.TULIP);
        Flower tulip2 = new Flower(FlowerType.TULIP, "pink", 5, 40);
        Flower tulip3 = new Flower(FlowerType.TULIP, "omnomnom", 5, 2000);
        System.out.println(rose2);
        System.out.println(chamomile2);
        System.out.println(tulip2);
        System.out.println("===================================================================================================");

        FlowerPack packRose1 = new FlowerPack(rose1,3);
        FlowerPack packRose2 = new FlowerPack(rose2,10);
        FlowerPack packChamomile1 = new FlowerPack(chamomile1,3);
        FlowerPack packChamomile2 = new FlowerPack(chamomile2,4);
        FlowerPack packChamomile3 = new FlowerPack(chamomile3,5);
        FlowerPack packTulip1 = new FlowerPack(tulip1,39);
        FlowerPack packTulip2 = new FlowerPack(tulip3,13);
        System.out.println(packRose1);
        System.out.println(packChamomile1);
        System.out.println(packTulip1);
        System.out.println("===================================================================================================");

        FlowerBucket bucket1 = new FlowerBucket(new ArrayList<>(Arrays.asList(packRose1, packTulip1, packTulip2)));
        FlowerBucket bucket2 = new FlowerBucket(new ArrayList<>(Arrays.asList(packChamomile1, packChamomile2)));
        bucket2.addFlowerPack(packChamomile3);
        FlowerBucket bucket3 = new FlowerBucket(new ArrayList<>(Arrays.asList(packTulip2, packRose2, packChamomile3)));
        System.out.println(bucket1);
        System.out.println(bucket2);
        System.out.println(bucket3);
        System.out.println("===================================================================================================");

        FlowersStore store1 = new FlowersStore();
        System.out.println(store1);
        store1.addBucket(bucket1);
        store1.addBucket(bucket2);
        System.out.println(store1);
        FlowersStore store2 = new FlowersStore(new ArrayList<>(Arrays.asList(bucket3, bucket3, bucket1)));
        System.out.println(store2);
        System.out.println("max prise = 2000");
        System.out.println("store1:" + store1.search(2000));
        System.out.println("store2:" + store2.search(2000));
    }
}