package pre.example.collection.runner;

public interface Runnable extends NodeRunner {

    /**
     * @apiNote if node is runnable, must be implement this method.
     *
     * @param  params parameter(s) of object
     * @return is successful running??
     * */
    boolean run(Object... params);
}
