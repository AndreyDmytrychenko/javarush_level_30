package task35.task3512;

public class Generator<T> {
    private Class<T> eventClass;
    public Generator(Class<T> eventClass) {
        this.eventClass = eventClass;
    }

    protected T newInstance() throws IllegalAccessException, InstantiationException {
        return eventClass.newInstance();
    }
}
