package items.flowers;

import items.Item;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;

@Getter @Setter @ToString
public class Flower extends Item {
    private double sepalLength, price;
    private FlowerType flowerType;
    private String color;
    private static final EnumMap<FlowerType, HashSet<String>> possibleColors;
    static {
        possibleColors = new EnumMap<>(FlowerType.class);
        possibleColors.put(FlowerType.ROSE, new HashSet<>(Arrays.asList("white", "yellow", "pink", "purple", "orange", "red")));
        possibleColors.put(FlowerType.TULIP, new HashSet<>(Arrays.asList("pink", "red", "white", "yellow", "purple")));
        possibleColors.put(FlowerType.CHAMOMILE, new HashSet<>(Arrays.asList("white", "yellow")));
    }

    public Flower(FlowerType flowerType) {
        this.description = "Tiny flower";
        this.flowerType = flowerType;
    }

    public Flower(FlowerType flowerType, String colorNew, double sepalLengthNew, double priceNew) {
        this.description = "Tiny flower";
        this.flowerType = flowerType;
        if (possibleColors.get(flowerType).contains(colorNew)) {
            this.color = colorNew;
        } else {
            this.color = "not def";
        }
        this.sepalLength = sepalLengthNew;
        this.price = priceNew;
    }

    public void setColor(String color) {
        if (possibleColors.get(flowerType).contains(color)) {
            this.color = color;
        } else {
            this.color = "none";
        }
    }

    public void setFlowerType(FlowerType flowerType) {
        this.flowerType = flowerType;
        this.color = "none";
        this.sepalLength = 0.;
        this.price = 0.;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
