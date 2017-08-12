class UnboxedIf extends Node {
    @Child Node condition;
    @Child Node thenBranch;
    @Child Node elseBranch;

    Object execute() {
        try {
            boolean conditionResult = condition.executeBoolean();
            if (conditionResult) {
                return thenBranch.execute();
            }
            else {
                return elseBranch.execute();
            }
        }
        catch (UnexpectedResultException e) {
            // handle type error
        }
    }
}
