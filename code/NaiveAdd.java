class NaiveAdd extends Node {
    @Specialization
    int addSimpleIntegers(int a, int b) {
        return a + b;
    }

    @Specialization
    PlsInteger addPlsIntegers(PlsInteger a, PlsInteger b) {
        if (a.isNull()) {
            return a;
        }
        else if (b.isNull()) {
            return b;
        }
        else {
            int safeAdd = Math.addExact(a.value, b.value);
            return new PlsInteger(safeAdd);
        }
    }
}
