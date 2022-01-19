package src.helpers;

// public interface Callback {
//     void call();
// }

public interface Callback<T> {
    void execute(T type);
}
