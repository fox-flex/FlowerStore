package payment;

public class PayPalPaymentStrategy extends PaymentStrategy {
    @Override
    public boolean pay(double price) {
        if (super.pay(price)) {
            System.out.println("Successfully pay by PayPal.");
            return true;
        } else {
            System.out.println("Fail while paying with PayPal.");
            return false;
        }
    }
}
