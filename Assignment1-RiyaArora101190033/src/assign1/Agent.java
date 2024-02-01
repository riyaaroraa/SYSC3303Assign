package assign1;

// By Riya Arora 101190033

import java.util.List;

// agent chooses at random two ingredients to be used

public class Agent extends Thread {

    private final int MIN_RANGE = 1;
    private final int MAX_RANGE = 3;
    private String name;
    private List<String> table;

    private String ingredient1;
    private String ingredient2;
    private String ingredient3;

    // all three ingredients are needed to complete the burger

    public Agent(String name, List<String> table, String ingredient1, String ingredient2, String ingredient3) {

        super(name);
        this.name = name;
        this.table = table;

        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.ingredient3 = ingredient3;
    }

    @Override
    public void run() {
        for (;;) {
            useIngredients(table);
        }
    }


    // this method chooses 2 of the 3 ingredients
    private synchronized boolean useIngredients(List<String> table) {
        // Check whether the table is full before adding ingredients
        while (!(table.isEmpty())) {

            try {
                System.out.println(name + " waiting for clear table");
                wait();

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
                System.err.println("ERROR: " + name);
                e.printStackTrace();
            }
        }
        int randomChoice = randomSelection(MIN_RANGE, MAX_RANGE);
        switch(randomChoice) {
            case 1:
                table.add(ingredient1);
                table.add(ingredient2);
                break;
            case 2:
                table.add(ingredient2);
                table.add(ingredient3);
                break;
            case 3:
                table.add(ingredient1);
                table.add(ingredient3);
                break;
            default:
                System.err.println("ERROR: no ingredient selected");
                break;
        }
        System.out.println(name + " has chosen 2 of the 3 given ingredients.");
        notifyAll();
        return true;
    }

    // this is where the two of three ingredients is chosen at random
    public int randomSelection(int min, int max) {
        int range = max - min + 1;
        return (int) (Math.random() * range + min);
    }


}