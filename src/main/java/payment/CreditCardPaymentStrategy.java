package payment;

public class CreditCardPaymentStrategy extends PaymentStrategy {
    @Override
    public boolean pay(double price) {
        if (super.pay(price)) {
            System.out.println("Successfully pay by Credit Card.");
            return true;
        } else {
            System.out.println("Fail while paying with Credit Card.");
            return false;
        }
    }
}
