package flowers;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter @Setter @ToString
public class FlowerBucket {
    private ArrayList<FlowerPack> flowerPacks = new ArrayList<>();

    public FlowerBucket() {}

    public FlowerBucket(ArrayList<FlowerPack> flowerPacks) {
        this.flowerPacks.addAll(flowerPacks);
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
}
