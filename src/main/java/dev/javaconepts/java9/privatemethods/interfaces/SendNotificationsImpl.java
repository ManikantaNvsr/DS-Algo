package dev.javaconepts.java9.privatemethods.interfaces;


public class SendNotificationsImpl implements SendNotifications {
    public static void main(String[] args) {
        SendNotifications sendNotifications = new SendNotificationsImpl();
        sendNotifications.sendNotification();
        sendNotifications.sendNotifications();
    }
}
