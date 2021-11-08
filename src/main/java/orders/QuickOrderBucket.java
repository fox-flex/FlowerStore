package orders;

import delivery.DeliveryStrategy;
import delivery.PostDeliveryStrategy;
import items.flowers.Flower;
import items.flowers.FlowerBucket;
import items.flowers.FlowerPack;
import lombok.Getter;
import payment.PayPalPaymentStrategy;
import payment.PaymentStrategy;
import items.flowers.FlowerType;

import java.util.*;

@Getter
public enum QuickOrderBucket {
    ROSE_BUCKET, TULIP_BUCKET, CHAMOMILE_BUCKET;
    private static final EnumMap<QuickOrderBucket, Flower> flowersMap;
    static {
        flowersMap = new EnumMap<>(QuickOrderBucket.class);
        flowersMap.put(QuickOrderBucket.ROSE_BUCKET, new Flower(FlowerType.ROSE, "red", 50,70));
        flowersMap.put(QuickOrderBucket.TULIP_BUCKET, new Flower(FlowerType.TULIP, "pink", 40,60));
        flowersMap.put(QuickOrderBucket.CHAMOMILE_BUCKET, new Flower(FlowerType.CHAMOMILE, "white", 20,100));
    }
    private static DeliveryStrategy deliveryStrategy = new PostDeliveryStrategy();
    private static PaymentStrategy paymentStrategy = new PayPalPaymentStrategy();

    public static void setDeliveryStrategy(DeliveryStrategy deliveryStrategyNew) {
        if (deliveryStrategyNew != null)
            deliveryStrategy = deliveryStrategyNew;
    }
    public static void setPaymentStrategy(PaymentStrategy paymentStrategyNew) {
        if (paymentStrategyNew != null)
            paymentStrategy = paymentStrategyNew;
    }

    public static Order OrderBucket(QuickOrderBucket type, int amount) {
        deliveryStrategy.setFastDelivery(false);
        deliveryStrategy.setFragileProductDelivery(false);
        paymentStrategy.setBalance(0.);
        Order order = new Order(deliveryStrategy, paymentStrategy);
        FlowerPack pack = new FlowerPack(flowersMap.get(type), amount);
        FlowerBucket bucket = new FlowerBucket(new ArrayList<>(Collections.singletonList(pack)));
        order.addItem(bucket);
        return order;
    }
    public static Order OrderBucket(QuickOrderBucket type, int amount, String color) {
        flowersMap.get(type).setColor(color);
        return OrderBucket(type, amount);
    }
}