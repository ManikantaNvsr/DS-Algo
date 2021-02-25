package dev.design.patterns.strategy;

public class StrategyDemo {
    public static void main(String[] args) {

        // Amex Strategy
        CreditCard amexCard = new CreditCard(new AmexStrategy());

        amexCard.setNumber("379185883464283");
        amexCard.setCvv("04/2020");
        amexCard.setDate("123");
        System.out.println("IS Amex valid: " + amexCard.isValid());

        CreditCard amexCard2 = new CreditCard(new AmexStrategy());

        amexCard2.setNumber("379185883464282");
        amexCard2.setCvv("04/2017");
        amexCard2.setDate("234");

        System.out.println("IS Amex valid: " + amexCard2.isValid());

        // Visa Strategy
        CreditCard visaCard = new CreditCard(new VisaStrategy());
        visaCard.setNumber("4530334455662233");
        visaCard.setDate("05/2018");
        visaCard.setCvv("324");

        System.out.println("IS Visa valid: " + visaCard.isValid());


        // Summary
        // If we have all the strategies in the main classes without implementing the strategy interface ValidationStrategy.
        // We'll be having lot of if statements in here to write different logic for amex and visa cards.
        // Behavior is encapsulated in strategy implementation classes.
        // client doesn't have to know what is inside strategy, they can choose the available strategy.


    }
}
