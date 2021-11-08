package users;

import lombok.Getter;

@Getter
public class Sender implements User {
    private final int id;
    public Sender() {
        id = setterID.getID();
    }

    @Override
    public void update() {
        System.out.println("Check your order, there are some news!");
    }
}
