package презентація.п1;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;

/**
 * Ланка потоку, з якої починається потік елементів (відповідає першій ланці кожного потоку)
 */
@RequiredArgsConstructor
public class Джерело<T> extends АбстрактнийБазовийПотік<T> {

    private final Iterator<T> джерело;

    @Override
    public boolean hasNext() {
        // TODO: треба реалізувати
        return false;
    }

    @Override
    public T next() {
        // TODO: треба реалізувати
        return null;
    }
}
