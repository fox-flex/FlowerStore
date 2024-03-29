package delivery;

import items.Item;
import payment.PaymentStrategy;

import java.util.List;

public class PostDeliveryStrategy extends DeliveryStrategy {
    private static final double deliveryPrice = 3., fastDeliveryPrice = 22.2, fragileProductPrice=14.2;

    @Override
    public boolean deliver(List<Item> items, boolean deliverDone) {
        if (deliverDone) {
            System.out.println("Delivered successfully!");
            return true;
        } else {
            System.out.println("At the moment delivering can't be done! Try again!");
            return false;
        }
    }

    @Override
    public double deliverPrice(List<Item> items) {
        return this.deliverPriceWithDep(items, "post", deliveryPrice, fastDeliveryPrice, fragileProductPrice);
    }

}
