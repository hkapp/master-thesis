final class SpecializedAddGen extends SpecializedAdd {

    @Child private Node leftNode;
    @Child private Node rightNode;
    @CompilationFinal private int state = 1;

    @Override
    Object execute() {
        Object leftValue = leftNode.execute();
        Object rightValue = rightNode.execute();
        if ((state & 0b10) != 0 /* is-active addIntegers(int, int) */
                        && leftValue instanceof Integer && rightValue instanceof Integer) {
            int leftIntValue = (int) leftValue;
            int rightIntValue = (int) rightValue;
            return addIntegers(leftIntValue, rightIntValue);
        }
        if ((state & 0b1000) != 0 /* is-active genericAdd(Object, Object) */) {
            return genericAdd(leftValue, rightValue);
        }
        /* No active specialization found to match */
        /* Need to specialize the node for the input */
        CompilerDirectives.transferToInterpreterAndInvalidate();
        return executeAndSpecialize(leftValue, rightValue);
    }

    private Object executeAndSpecialize(Object leftValue, Object rightValue) {
        if (leftValue instanceof Integer && rightValue instanceof Integer) {
            int leftIntValue = (int) leftValue;
            int rightIntValue = (int) rightValue;
            this.state = state | 0b10 /* add-active addIntegers(int, int) */;
            return addIntegers(leftIntValue, rightIntValue);
        }
        this.state = state | 0b1000 /* add-active genericAdd(Object, Object) */;
        return genericAdd(leftValue, rightValue);
    }

}
