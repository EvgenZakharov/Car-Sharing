import java.util.Locale;

class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        Coffee simpleEspresso = new Espresso();
        System.out.println(/* write your code here */simpleEspresso.getDescription() + " $" + formatSum(simpleEspresso.cost()/* write your code here */));

        Coffee espressoWithDecor = new Espresso()/* write your code here */;
        espressoWithDecor = new Milk(espressoWithDecor/* write your code here */);
        espressoWithDecor = new Sugar(espressoWithDecor/* write your code here */);
        System.out.println(/* write your code here */espressoWithDecor.getDescription() + " $" + formatSum(espressoWithDecor.cost()/* write your code here */));

        Coffee instantWithDecor = new InstantCoffee()/* write your code here */;
        instantWithDecor = new WhippedCream(instantWithDecor/* write your code here */);
        instantWithDecor = new Sugar(instantWithDecor/* write your code here */);
        instantWithDecor = new Sugar(instantWithDecor/* write your code here */);
        instantWithDecor = new Sugar(instantWithDecor/* write your code here */);
        System.out.println(/* write your code here */instantWithDecor.getDescription() + " $" + formatSum(instantWithDecor.cost()/* write your code here */));

        System.out.println("I'm drinking my " + instantWithDecor.getDescription());
        Thread.sleep(1500);
        System.out.println("-I want to add some Whipped Cream to my coffee. And don't make a new one! Just add Whipped Cream");
        Thread.sleep(1500);
        System.out.println("-Okay! But the final price will change");
        Thread.sleep(1500);
        System.out.println("-I understand");

        instantWithDecor = new WhippedCream(instantWithDecor/* write your code here */);
        System.out.println(/* write your code here */instantWithDecor.getDescription() + " $" + formatSum(instantWithDecor.cost()/* write your code here */));
    }

    private static String formatSum(double sum) {
        return String.format(Locale.ROOT, "%.2f", sum);
    }
}

abstract class Coffee {
    String description;

    String getDescription() {
        return description;
    }

    abstract double cost();
}

class Espresso extends Coffee {

    Espresso() {
        description = "Espresso";
    }

    @Override
    double cost() {
        return 1.99;
    }
}

class InstantCoffee extends Coffee {

    InstantCoffee() {
        description = "Instant Coffee";
    }

    @Override
    double cost() {
        return 1.0;
    }
}

abstract class Decorator extends Coffee {
    abstract String getDescription();
}

class Milk extends Decorator {

    private Coffee coffee;

    /* write constructor */

    public Milk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    String getDescription() {
        return /* write your code here */ coffee.getDescription() + ", Milk";
    }

    @Override
    double cost() {
        return .13 + coffee.cost()/* write your code here */;
    }
}

class Sugar extends Decorator {

    private Coffee coffee;

        /* write constructor */

    public Sugar(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    String getDescription() {
        return /* write your code here */ coffee.getDescription() + ", Sugar";
    }

    @Override
    double cost() {
        return .02 + coffee.cost()/* write your code here */;
    }
}

class WhippedCream extends Decorator {

    private Coffee coffee;

        /* write constructor */

    public WhippedCream(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    String getDescription() {
        return /* write your code here */ coffee.getDescription() + ", Whipped Cream";
    }

    @Override
    double cost() {
        return .10 + coffee.cost()/* write your code here */;
    }
}