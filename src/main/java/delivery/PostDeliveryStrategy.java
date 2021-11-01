package delivery;

import items.Item;
import payment.PaymentStrategy;

import java.util.List;

public class PostDeliveryStrategy extends DeliveryStrategy {
    private static final double deliveryPrice = 5., fastDeliveryPrice = 12.5, fragileProductPrice=22.2;

//    public PostDeliveryStrategy() {super();};
//
//    public PostDeliveryStrategy(boolean fastDelivery, boolean fragileProduct) {
//        super(fastDelivery, fragileProduct);
//    };

    @Override
    public boolean deliver(List<Item> items, PaymentStrategy paymentStrategy) {
        return true;
    }

    @Override
    public double deliverPrice(List<Item> items) {
        return this.deliverPriceWithDep(items, "post", deliveryPrice, fastDeliveryPrice, fragileProductPrice);
    }

}
