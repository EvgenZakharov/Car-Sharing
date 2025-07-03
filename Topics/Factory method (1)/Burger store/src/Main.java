class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        /* write your code here */
        BurgerFactory burgerStore = new BurgerStore();
        Burger chineseBurger = burgerStore.createBurger("ChineseBurger");
        burgerStore.orderBurger("ChineseBurger");

        Burger americanBurger = burgerStore.createBurger("AmericanBurger");
        burgerStore.orderBurger("AmericanBurger");

        Burger russianBurger = burgerStore.createBurger("RussianBurger");
        burgerStore.orderBurger("RussianBurger");

    }
}

abstract class BurgerFactory {

    abstract Burger createBurger(String type);

    Burger orderBurger(String type) throws InterruptedException {
        Burger burger = createBurger(type);
        if (burger == null) {
            System.out.println("Sorry, we are unable to create this kind of burger\n");
            return null;
        }
        System.out.println("Making a " + burger.getName());
        /* write your code here */
        burger.putBun();
        /* write your code here */
        burger.putCutlet();
        /* write your code here */
        burger.putSauce();
        Thread.sleep(1500L);
        System.out.println(burger.getName() + " ready" + "\n");
        return burger;
    }
}

class BurgerStore extends BurgerFactory {
    @Override
    Burger createBurger(String type) {
        switch (type) {
            case ("ChineseBurger"):
                /* write your code here */
                return new ChineseBurger("Chinese Burger");
            case ("AmericanBurger"):
                /* write your code here */
                return new AmericanBurger("American Burger");
            case ("RussianBurger"):
                /* write your code here */
                return new RussianBurger("Russian Burger");
            default:
                return null;
        }
    }
}

abstract class Burger {
    private String name;

    Burger(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void putBun() {
        System.out.println("Putting bun");
    }

    void putCutlet() {
        System.out.println("Putting patty");
    }

    void putSauce() {
        System.out.println("Putting sauce");
    }

}

class ChineseBurger extends Burger {
    /* write your code here */
    ChineseBurger(String name) {
        super(name);
    }
}

class AmericanBurger extends Burger {
    /* write your code here */
    AmericanBurger(String name) {
        super(name);
    }
}

class RussianBurger extends Burger {
    /* write your code here */
    RussianBurger(String name) {
        super(name);
    }
}