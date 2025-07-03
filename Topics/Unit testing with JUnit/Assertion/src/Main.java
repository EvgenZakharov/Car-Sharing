class CalculatorTests {
    public void testCalculator() {
        Calculator calculator = new Calculator();
        int result = calculator.add(1, 2);
        Assertions.assertEquals(3, result);
    }
}
