class Add extends Node {
    @Specialization
    int addIntegers(int a, int b) {
        return a + b;
    }

    @Specialization
    double addDoubles(double a, double b) {
        return a + b;
    }

    @Specialization
    String concatStrings(String a, String b) {
        return a.concat(b);
    }
}
