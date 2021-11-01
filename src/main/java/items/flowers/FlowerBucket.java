package items.flowers;

import items.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter @Setter @ToString
public class FlowerBucket extends Item {
    private ArrayList<FlowerPack> flowerPacks = new ArrayList<>();

    public FlowerBucket() {
        this.description = "Bed bucket!";
    }

    public FlowerBucket(ArrayList<FlowerPack> flowerPacks) {
        this.flowerPacks.addAll(flowerPacks);
        this.description = "AAAAAAAA";
    }

    public FlowerBucket(ArrayList<FlowerPack> flowerPacks, String description) {
        this.flowerPacks.addAll(flowerPacks);
        this.description = description;
    }

    public void addFlowerPack(FlowerPack flowerPackNew) {
        flowerPacks.add(flowerPackNew);
    }

    public double getPrice() {
        double price = 0.;
        for (FlowerPack flower : this.flowerPacks) {
            price += flower.getPrice();
        }
        return price;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
