package презентація.п4;

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
        return джерело.hasNext();
    }

    @Override
    public T next() {
        return джерело.next();
    }
}
