abstract class Node {
    abstract Object execute();
    abstract int executeInt()
        throws UnexpectedResultException;
    abstract boolean executeBoolean()
        throws UnexpectedResultException;
}
