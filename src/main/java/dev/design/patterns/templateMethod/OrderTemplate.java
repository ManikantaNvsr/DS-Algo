package dev.design.patterns.templateMethod;

public abstract class OrderTemplate {
    public boolean isGift;

    public abstract void doCheckOut();

    public abstract void doPayment();

    public abstract void doReceipt();

    public abstract void doDelivery();


    public final void wrapGift() {
        System.out.println("Gift was wrapped");
    }

    public final void processOrder() {
        doCheckOut();
        doPayment();
        if (isGift) {
            wrapGift();
        } else {
            doReceipt();
        }
        doDelivery();
    }
}
