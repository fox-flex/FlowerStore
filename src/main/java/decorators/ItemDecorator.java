package decorators;

import items.Item;

public class ItemDecorator extends Item {
    private Item item;
    private double sale = 1.;

    public ItemDecorator(Item item) {
        this.item = item;
    }

    public ItemDecorator(Item item, double sale) {
        this.item = item;
        this.sale = sale;
    }

    public void setSale(double sale) {
        if (0 <= sale && sale <= 1.)
            this.sale = sale;
    }
    public double getSale() {
        return this.sale;
    }


    @Override
    public double getPrice() {
        return this.item.getPrice() * this.sale;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
