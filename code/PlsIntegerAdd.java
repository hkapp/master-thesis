class PlsIntegerAdd extends Node {
    @Specialization
    int addNonNull(int a, int b) {
        return a + b;
    }

    @Specialization
    NULL addNullLeft(NULL a, Object b) {
        return a;
    }

    @Specialization
    NULL addNullRight(Object a, NULL b) {
        return b;
    }
}
