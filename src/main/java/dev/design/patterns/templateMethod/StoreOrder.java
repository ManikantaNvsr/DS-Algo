package dev.design.patterns.templateMethod;


public class StoreOrder extends OrderTemplate {
    @Override
    public void doCheckOut() {
        System.out.println("Ring up items from cart");
    }

    @Override
    public void doPayment() {
        System.out.println("Process payment with card present");
    }

    @Override
    public void doReceipt() {
        System.out.println("Print Receipt");
    }

    @Override
    public void doDelivery() {
        System.out.println("bag items at counter");
    }
}
