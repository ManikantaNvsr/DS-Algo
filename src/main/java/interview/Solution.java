package interview;

import java.util.*;

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

        List<Map.Entry<String, Integer>> listOfItemAndQuantities = new ArrayList<>(itemAndQuantity.entrySet());

        // sort the itemAndQuantity based on the quantity


        // This is old way of doing
        Collections.sort(listOfItemAndQuantities, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                return o1.getValue().compareTo(o2.getValue());
            }
        });

        listOfItemAndQuantities.sort((a, b) -> b.getValue().compareTo(a.getValue()));
    }
}
