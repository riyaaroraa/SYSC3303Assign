package assign1;

// By Riya Arora 101190033
// This is the file you run in order to run the full program

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

// Kitchen is where burger is made
public class Kitchen {

    public static int count = 0;

    public static void main(String[] args) {
        if (args.length == 0) {
            new Kitchen().makeBurger();
        }
    }


    //intialize
    private void makeBurger() {
        List<String> table = Collections.synchronizedList(new ArrayList<>());

        Thread agent = new Agent("agent", table, "bun", "chicken", "mayo");
        Thread chef1 = new Chef("chef1", table, "bun");
        Thread chef2 = new Chef("chef2", table, "chicken");
        Thread chef3 = new Chef("chef3", table, "mayo");

        System.out.println("Hello!! Welcome to Burger Kitchen!!");

        agent.start();
        chef1.start();
        chef2.start();
        chef3.start();
    }


}