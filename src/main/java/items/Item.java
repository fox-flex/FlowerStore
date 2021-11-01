package items;


import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public abstract class Item {
    protected String description;
    public abstract double getPrice();
    public abstract String getDescription();
}
