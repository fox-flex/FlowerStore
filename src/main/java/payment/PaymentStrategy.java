package payment;

import lombok.Getter;
import lombok.Setter;

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
}
