class SimpleCounter {
    // write your code here
    public int counter;

    private final static SimpleCounter INSTANCE = new SimpleCounter();

    private SimpleCounter() { }

    public static SimpleCounter getInstance () {
        return INSTANCE;
    }

}