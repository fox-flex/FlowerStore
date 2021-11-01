package decorators;

import items.Item;

public class PaperDecorator extends ItemDecorator {
    private static final double additionalPrice = 13.21;

    public PaperDecorator(Item item) {
        super(item);
    }

    public PaperDecorator(Item item, double sale) {
        super(item, sale);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + additionalPrice;
    }

    @Override
    public String getDescription() {
        return this.getDescription() + " Decorated by paper.";
    }
}
