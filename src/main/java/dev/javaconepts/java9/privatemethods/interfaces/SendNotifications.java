package dev.javaconepts.java9.privatemethods.interfaces;

public interface SendNotifications {
    default void sendNotifications() {
        estblishConnection();
        System.out.println("Sending Multiple Notifications");
    }

    default void sendNotification() {
        System.out.println("Sending a single notification");
    }

    private void estblishConnection() {
        System.out.println("Establishing a connection");
    }
}
