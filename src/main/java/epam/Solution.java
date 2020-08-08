package epam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {

        // ArrayList<order>
        // order contains orderId, itemId, itemName, quantity

        ArrayList<order> ordersList = new ArrayList<>();

        // hashmap to store the item and their quantities
        HashMap<String, Integer> itemAndQuantity = new HashMap();

        // iterate through all the orders
        for (order eachOrder : ordersList) {
            if (itemAndQuantity.keySet().contains(eachOrder.itemName)) {
                int quantityForThisOrder = itemAndQuantity.get(eachOrder.itemName);
                quantityForThisOrder += eachOrder.getQuantity();
                itemAndQuantity.put(eachOrder.itemName, quantityForThisOrder);
            } else {
                itemAndQuantity.put(eachOrder.itemName, eachOrder.quantity);
            }

        }

        // sort the itemAndQuantity based on the quantity


    }
}
