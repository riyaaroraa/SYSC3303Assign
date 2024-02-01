package assign1;

// By Riya Arora 101190033

import java.util.List;

// first class Chef = one ingredient to make a burger

public class Chef extends Thread {

    private String name;
    private String ingredient;
    private List<String> table;
    private final int MAX_BURGERS = 20;

    // ingredient = needed to complete a burger
    // table = burger is placed on this

    public Chef(String name, List<String> table, String ingredient) {
        super(name);
        this.table = table;
        this.ingredient = ingredient;
    }


    @Override
    public void run() {
        do {
            getBurger();
        } while (Kitchen.count < MAX_BURGERS);

        System.out.println("Program is Complete.");
        System.exit(0);
    }


    // make a burger with all ingredients

    private synchronized Object getBurger() {
        Object obj = table;
        for (String foodItem : table) {
            while (table.isEmpty() || foodItem.equals(ingredient)) {

                try {
                    System.out.println(name + " is waiting for ingredients.");
                    wait();

                } catch (InterruptedException e) {
                    System.err.println("ERROR: " + name);
                    e.printStackTrace();
                }
            }
        }
        // table clear means eat the burger

        Kitchen.count++;
        table.clear();

        String message = String.format("%s made a yummy burger by choosing %s to add to the table.", name, ingredient);
        String totalBurgersMessage = String.format("%s made a total of %d burgers.", name, Kitchen.count);

        System.out.println(message);
        System.out.println(totalBurgersMessage);

        notifyAll();
        return obj;

    }

}
