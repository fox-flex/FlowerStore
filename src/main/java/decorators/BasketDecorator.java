package decorators;

import items.Item;

public class BasketDecorator extends ItemDecorator{
    private static final double additionalPrice = 13;

    public BasketDecorator(Item item) {
        super(item);
    }

    public BasketDecorator(Item item, double sale) {
        super(item, sale);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + additionalPrice;
    }

    @Override
    public String getDescription() {
        return this.getDescription() + " Decorated by basket.";
    }
}
