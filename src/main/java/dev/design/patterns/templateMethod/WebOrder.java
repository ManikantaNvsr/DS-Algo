package dev.design.patterns.templateMethod;

public class WebOrder extends OrderTemplate {
    @Override
    public void doCheckOut() {
        System.out.println("Get items from cart");
        System.out.println("Set gift preferences");
        System.out.println("Set delivery address");
        System.out.println("Set billing address");
    }

    @Override
    public void doPayment() {
        System.out.println("Process payment without card present");
    }

    @Override
    public void doReceipt() {
        System.out.println("Email Receipt");
    }

    @Override
    public void doDelivery() {
        System.out.println("Ship item to the address");
    }
}
