package пакетик;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;

/**
 * Created by roman on 03.04.17.
 */
@RequiredArgsConstructor
public class СправжнійПотік<T> implements Потік<T> {

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
