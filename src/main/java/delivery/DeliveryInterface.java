package delivery;


import items.Item;
import payment.PaymentStrategy;

import java.util.List;

public interface DeliveryInterface {
    boolean deliver(List<Item> items, boolean paymentDone);
}
