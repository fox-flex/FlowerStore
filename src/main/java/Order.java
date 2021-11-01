import decorators.BasketDecorator;
import decorators.PaperDecorator;
import decorators.RibbonDecorator;
import delivery.DeliveryStrategy;
import items.Item;
import payment.PaymentStrategy;

import java.util.LinkedList;
import java.util.Objects;

public class Order {
    DeliveryStrategy deliveryStrategy = null;
    PaymentStrategy paymentStrategy = null;
    LinkedList<Item> items;

    public Order(LinkedList<Item> items) {
        this.items = items;
    }

    public Order(LinkedList<Item> items, DeliveryStrategy deliveryStrategy, PaymentStrategy paymentStrategy) {
        this.items = items;
        this.paymentStrategy = paymentStrategy;
        this.deliveryStrategy = deliveryStrategy;
    }

    void setFastDelivery(boolean fastDelivery) {
        deliveryStrategy.setFastDelivery(fastDelivery);
    }
    void setFragileProductDelivery(boolean fragileProductDelivery) {
        deliveryStrategy.setFragileProductDelivery(fragileProductDelivery);
    }

    public void addItem(Item item) {
        System.out.println("Add item to bucket!");
        this.items.add(item);
    }

    public void decorateItemInIndex(int ind, String decor) {
        if (0 <= ind && ind < this.items.size()) {
            switch (decor) {
                case "paper":
                    this.items.set(ind, new PaperDecorator(this.items.get(ind)));
                    break;
                case "basket":
                    this.items.set(ind, new BasketDecorator(this.items.get(ind)));
                    break;
                case "ribbon":
                    this.items.set(ind, new RibbonDecorator(this.items.get(ind)));
                    break;
                default:
                    System.out.println("no such type of decor are available.");
            }
            System.out.println("Decorate item in " + ind + " position.");
        }
        System.out.println("Incorrect position of item.");
    }

    public double getPrice() {
        double price = 0.;
        for (Item item : items) {
            price += item.getPrice();
        }
        return price;
    }

    public boolean pay() {
        if (paymentStrategy.pay(this.getPrice())) {
            System.out.println("Transaction done successfully!");
            return true;
        } else {
            System.out.println("Transaction go incorrect! Place check your balance and try again!");
            return false;
        }
    }

    public boolean deliver() {
        if (this.deliveryStrategy.deliver(this.items, this.paymentStrategy)) {
            this.items.clear();
            System.out.println("No items to deliver now!");
            return true;
        }
        return false;
    }

    public void processOrder() {
        if (this.pay()) {
            if (this.deliver()) {
                System.out.println("Order finished successfully!");
                return;
            }
            System.out.println("Fail at delivering!");
        }
        System.out.println("Fail at payment process!");
    }
}
