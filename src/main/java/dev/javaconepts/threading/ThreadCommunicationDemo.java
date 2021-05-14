package dev.javaconepts.threading;

public class ThreadCommunicationDemo {

    public static void main(String[] args) throws InterruptedException {

        ResourceLock lock = new ResourceLock();

        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    while (lock.counter < 100) {

                        if (lock.counter % 2 == 0) {
                            lock.counter++;
                            System.out.println("Thread1: " + lock.counter);
                            lock.notify();
                        } else {
                            lock.wait();
                        }
                    }


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                try {
                    while (lock.counter < 100) {

                        if (lock.counter % 2 != 0) {
                            lock.counter++;
                            System.out.println("Thread2: " + lock.counter);
                            lock.notify();
                        } else {
                            lock.wait();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        thread1.start();
        thread2.start();
    }
}

class ResourceLock {
    int counter = 0;
}

