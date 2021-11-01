package delivery;

import items.Item;
import lombok.Getter;
import lombok.Setter;
import payment.PaymentStrategy;

import java.util.List;

@Getter @Setter
public abstract class DeliveryStrategy implements DeliveryInterface {
    private boolean fastDelivery = false;
    private boolean fragileProductDelivery = false;

    public DeliveryStrategy() {}

    public DeliveryStrategy(boolean fastDelivery, boolean fragileProduct) {
        this.fastDelivery = fastDelivery;
        this.fragileProductDelivery = fragileProduct;
    }


    public abstract boolean deliver(List<Item> items, boolean deliverDone);

    public abstract double deliverPrice(List<Item> items);

    protected double deliverPriceWithDep(List<Item> items, String deliveryName,
                                    double deliveryPrice, double fastDeliveryPrice, double fragileProductPrice) {
        System.out.print("Delivering " + items.size() + " items by " + deliveryName + ".");
        double price;
        if (this.fastDelivery) {
            System.out.print(" Additional payment for fast delivery.");
            price = fastDeliveryPrice;
        } else {
            price = deliveryPrice;
        }
        if (fragileProductDelivery) {
            System.out.print(" Additional payment for fragile product delivery.");
            price += fragileProductPrice;
        }
        return price * items.size();
//        return (this.fastDelivery) ? fastDeliveryPrice : deliveryPrice;
    }
}
