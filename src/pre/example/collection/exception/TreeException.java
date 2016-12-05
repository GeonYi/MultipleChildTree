package pre.example.collection.exception;

abstract class TreeException extends Exception{

    protected TreeException() {
        super("tree exception");
    }

    protected TreeException(String msg) {
        super("tree exception cause : " + msg);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tree make failed ").append(super.getMessage());
        return sb.toString();
    }
}
