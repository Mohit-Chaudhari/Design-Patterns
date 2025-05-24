package structural.adapter;

/**
 * @author Mohit Chaudhari
 * <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Linkedin - Mohit Chaudhari</a>
 * Created date: 24/05/25
 */

interface PaymentGateway {
    void pay(String orderId, double amount);
}

class PayUGateway implements PaymentGateway {
    @Override
    public void pay(String orderId, double amount) {
        System.out.println("Paying amount of RS. " + amount + " via PayU gateway for order id : " + orderId);
    }
}

// Adaptee
// An existing class with an incompatible interface
class RazorPayAPI {
    public void makePayment(String orderId, double amount) {
        System.out.println("Paying amount of RS. " + amount + " via RazorPay gateway for order id : " + orderId);
    }
}

class RazorPayAdapter implements PaymentGateway {

    private final RazorPayAPI razorPayAPI;

    public RazorPayAdapter() {
        this.razorPayAPI = new RazorPayAPI();
    }

    @Override
    public void pay(String orderId, double amount) {
        this.razorPayAPI.makePayment(orderId, amount);
    }
}

class CheckoutService {
    private final PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void checkout(String orderId, double amount) {
        paymentGateway.pay(orderId, amount);
    }
}

public class Checkout {
    public static void main(String[] args) {
        CheckoutService payu = new CheckoutService(new PayUGateway());
        payu.checkout("1234", 90);

        CheckoutService razorpay = new CheckoutService(new RazorPayAdapter());
        razorpay.checkout("5678", 30);
    }
}
