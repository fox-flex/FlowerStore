package users;

import lombok.Getter;

@Getter
public class Receiver implements User {
    private final int id;
    public Receiver() {
        id = setterID.getID();
    }

    @Override
    public void update() {
        System.out.println("Check your order, there are some news!");
    }
}
