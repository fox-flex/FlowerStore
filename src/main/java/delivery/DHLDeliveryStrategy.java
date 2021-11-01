package delivery;

import items.Item;
import payment.PaymentStrategy;

import java.util.List;

public class DHLDeliveryStrategy extends DeliveryStrategy {
    private static final double deliveryPrice = 5., fastDeliveryPrice = 12.5, fragileProductPrice = 10.;

    @Override
    public boolean deliver(List<Item> items, PaymentStrategy paymentStrategy) {
        if (paymentStrategy.pay(deliverPrice(items))) {
            System.out.println("Delivered successfully!");
            return true;
        } else {
            System.out.println("Not enough money to pay for delivering! Try again!");
            return false;
        }
    }

    @Override
    public double deliverPrice(List<Item> items) {
        return this.deliverPriceWithDep(items, "DHL", deliveryPrice, fastDeliveryPrice, fragileProductPrice);
    }

}
