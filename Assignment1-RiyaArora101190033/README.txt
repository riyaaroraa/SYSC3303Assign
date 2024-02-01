@author Riya Arora 101190033
@version 1.0
@date 22/02/2024

# Burger Making Simulation

The program in Java simulates a scenario where three chef threads and one agent thread work together to produce and enjoy burgers. Each chef needs three ingredients (bun, chicken, and mayo) for a burger. The agent randomly picks two out of the three ingredients, sets them on a table, and the chef possessing the remaining ingredient assembles and consumes the burger.

## Files

- `Agent.java`: Represents the Agent thread that randomly selects two ingredients and places them on the table.

- `Chef.java`: Represents the Chef thread that creates and consumes burgers based on the available ingredients.

- `Kitchen.java`: The main class that initializes and starts the agent and chef threads.

## Running the Program

1. Compile the Java files:

   ```bash
   javac Agent.java Chef.java Kitchen.java

2. Or you can run the program by running Kitchen.java

LOGIC 

The agent randomly selects two out of the three ingredients and places them on the table.
A chef with the remaining ingredient on the table makes and consumes a burger.
The program continues until a total of 20 burgers have been made and consumed

Class Descriptions:

AGENT

The Agent class represents the agent thread that randomly selects two ingredients and places them on the table. It has the following attributes:

name: The name of the agent thread.
table: The list representing the table where ingredients are placed.
ingredient1, ingredient2, ingredient3: The three ingredients needed to make a burger.
The run method continuously calls the useIngredients method to choose two ingredients randomly.

The useIngredients method is synchronized to ensure proper coordination between the agent and chef threads. It randomly selects two out of the three ingredients and adds them to the table

CHEF

The Chef class represents a chef thread that creates and consumes burgers based on the available ingredients. It has the following attributes:

name: The name of the chef thread.
table: The list representing the table where ingredients are placed.
ingredient: The specific ingredient needed by the chef to make a burger.
The run method continuously calls the getBurger method to make a burger with the available ingredients.

The getBurger method is synchronized to ensure proper coordination between the chef and agent threads. It checks for the required ingredient on the table and, if available, makes a burger and consumes it

KITCHEN

The Kitchen class is the main class where the burger-making simulation is initialized. It creates the necessary threads (Agent and Chefs) and starts their execution.

The program will run until 20 burgers have been made and consumed

OTHER

Modify the MIN_RANGE and MAX_RANGE values in Agent.java to set the range for random ingredient selection. Feel free to tailor and expand the program according to your requirements.


