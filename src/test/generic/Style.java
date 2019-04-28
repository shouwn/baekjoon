package test.generic;

public interface Style<T> {

    default T let() {
        return (T) this;
    }
}
