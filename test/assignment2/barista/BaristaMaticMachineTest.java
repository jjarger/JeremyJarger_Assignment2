package assignment2.barista;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BaristaMaticMachineTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("-------------------------------------");
    }

    @Test
    public void test1() {
        Drink decafCoffee = new Drink("Decaf Coffee");
        decafCoffee = (new DecafCoffee()).addTo(decafCoffee);
        decafCoffee = (new DecafCoffee()).addTo(decafCoffee);
        decafCoffee = (new DecafCoffee()).addTo(decafCoffee);
        decafCoffee = (new Sugar()).addTo(decafCoffee);
        decafCoffee = (new Cream()).addTo(decafCoffee);
        assertTrue(decafCoffee.getDescription().equals(("Decaf Coffee"))
                && decafCoffee.cost() == 275);
    }

    @Test
    public void test2() {
        Inventory inventory = new Inventory();
        Recipe decafCoffeeMaker = new DecafCoffeeRecipe(inventory);
        Drink decafCoffee = decafCoffeeMaker.makeDrink();
        assertTrue(decafCoffee.getDescription().equals(("Decaf Coffee"))
                && decafCoffee.cost() == 275);
    }

    @Test
    public void test3() {
        Inventory inventory = new Inventory();
        inventory.display();
        Recipe decafCoffeeMaker = new DecafCoffeeRecipe(inventory);
        decafCoffeeMaker.makeDrink();
        inventory.display();
        decafCoffeeMaker.makeDrink();
        decafCoffeeMaker.makeDrink();
        decafCoffeeMaker.makeDrink();
        inventory.restock();
        decafCoffeeMaker.makeDrink();
    }

    @Test
    public void test4() {
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        inventory.display();
        menu.display();
        menu.makeDrink(5);
        inventory.display();
        menu.makeDrink(5);
        menu.makeDrink(5);
        menu.makeDrink(5);
        menu.display();
        inventory.restock();
        menu.makeDrink(5);
    }

    @Test
    public void test5() {
        Inventory inventory = new Inventory();
        Menu menu = new Menu(inventory);
        class DecafCaffeMochaRecipe extends Recipe {

            public DecafCaffeMochaRecipe(Inventory inventory) {
                super("Decaf Caffe Mocha", inventory);
            }

            @Override
            public void setRecipe() {
                addIngredient("Decaf Coffee", 1);
                addIngredient("Cocoa", 1);
                addIngredient("Steamed Milk", 1);
                addIngredient("Whipped Cream", 1);
            }

        }
        menu.addRecipe(new DecafCaffeMochaRecipe(inventory));
        inventory.display();
        menu.display();
        menu.makeDrink(6);
        inventory.display();
        menu.display();
    }

}
