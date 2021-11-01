package items;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class Koktus extends Item {
    private double price;

    public Koktus() {
        this.price = 100_000.;
    }
    public Koktus(double price) {
        this.price = price;
    }
    public Koktus(double price, String description) {
        this.price = price;
        this.description = description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public double setPrice(double price) {
        return price =price;
    }


    @Override
    public String getDescription() {
        return this.description;
    }
}
