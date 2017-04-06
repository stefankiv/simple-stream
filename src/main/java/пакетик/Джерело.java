package пакетик;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;

/**
 * Created by roman on 06.04.17.
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
