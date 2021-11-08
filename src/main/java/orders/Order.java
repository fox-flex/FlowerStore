package orders;

import decorators.BasketDecorator;
import decorators.DecorType;
import decorators.PaperDecorator;
import decorators.RibbonDecorator;
import delivery.DeliveryStrategy;
import items.Item;
import payment.PaymentStrategy;
import users.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Order {
    private final DeliveryStrategy deliveryStrategy;
    private final PaymentStrategy paymentStrategy;
    private final LinkedList<Item> items;
    private List<User> users;
    private boolean paid = false;

    public Order(DeliveryStrategy deliveryStrategy, PaymentStrategy paymentStrategy) {
        this.items = new LinkedList<>();
        this.paymentStrategy = paymentStrategy;
        this.deliveryStrategy = deliveryStrategy;
        this.users = new ArrayList<>();
    }

    public Order(LinkedList<Item> items, DeliveryStrategy deliveryStrategy, PaymentStrategy paymentStrategy) {
        this.items = items;
        this.paymentStrategy = paymentStrategy;
        this.deliveryStrategy = deliveryStrategy;
        this.users = new ArrayList<>();
    }

    public void updateBalance(double money) {
        this.paymentStrategy.addToBalance(money);
    }

    public double getBalance() {
        return this.paymentStrategy.getBalance();
    }

    void setFastDelivery(boolean fastDelivery) {
        deliveryStrategy.setFastDelivery(fastDelivery);
    }

    void setFragileProductDelivery(boolean fragileProductDelivery) {
        deliveryStrategy.setFragileProductDelivery(fragileProductDelivery);
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void addItem(Item item) {
        if (paid) {
            System.out.println("Firstly deliver previous order!");
            return;
        }
        System.out.println("Add item to bucket!");
        this.items.add(item);
    }

    public void clearItems() {
        this.items.clear();
    }

    public void decorateItemInIndex(int ind, DecorType decor) {
        if (0 <= ind && ind < this.items.size()) {
            switch (decor) {
                case PAPER:
                    this.items.set(ind, new PaperDecorator(this.items.get(ind)));
                    break;
                case BASKET:
                    this.items.set(ind, new BasketDecorator(this.items.get(ind)));
                    break;
                case RIBBON:
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
        if (paid)
            return 0.;
        double price = 0.;
        for (Item item : items) {
            price += item.getPrice();
        }
        return price + this.deliveryStrategy.deliverPrice(this.items);
    }

    public boolean pay() {
        if (this.paid) {
            System.out.println("You already pay for it!");
            return true;
        }
        if (paymentStrategy.pay(this.getPrice())) {
            System.out.println("Transaction done successfully!");
            this.paid = true;
            return true;
        } else {
            System.out.println("Transaction go incorrect! Place check your balance and try again!");
            return false;
        }
    }

    public boolean deliver() {
        if (this.paid) {
            System.out.println("All " + this.items.size() + " items delivered. No items in backed now!");
            this.items.clear();
            this.paid = false;
            return true;
        }
        System.out.println("Firstly you near to pay for order!");
        return false;
    }

    public boolean processOrder() {
        if (this.paid || this.pay()) {
            if (this.deliver()) {
                System.out.println("orders.Order finished successfully!");
                this.paid = false;
                return true;
            } else {
                System.out.println("Fail at delivering!");
                return false;
            }
        } else {
            System.out.println("Fail at payment process!");
            return false;
        }
    }

    // Work with users
    public void addUser(User user) {
        this.users.add(user);
    }

    public void delUser(User user) {
        this.users.remove(user);
    }

    public void notifyUsers() {
        for (User user : this.users)
            user.update();
    }

    public void order() {
        this.notifyUsers();
    }
}
