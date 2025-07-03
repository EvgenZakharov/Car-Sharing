class Main {
    public static void main(String... args) {
        // code
        ClassLoader mainClassLoader = Main.class.getClassLoader();
        System.out.println(mainClassLoader.getName());
    }
}