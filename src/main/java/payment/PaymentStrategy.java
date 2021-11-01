package payment;

import lombok.Getter;
import lombok.Setter;

import static java.lang.Math.max;

@Getter @Setter
public class PaymentStrategy implements PaymentInterface {
    private double balance = 0.;

    @Override
    public boolean pay(double price) {
        if (price < this.balance) {
            this.balance -= price;
            return true;
        }
        return false;
    }

    public void addToBalance(double money) {
        this.balance += max(0, money);
    }
}
