package decorators;

import items.Item;

public class RibbonDecorator extends ItemDecorator{
    private static final double additionalPrice = 39;

    public RibbonDecorator(Item item) {
        super(item);
    }

    public RibbonDecorator(Item item, double sale) {
        super(item, sale);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + additionalPrice;
    }

    @Override
    public String getDescription() {
        return this.getDescription() + "  Ribbon decorated.";
    }
}
