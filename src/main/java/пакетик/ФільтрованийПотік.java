package пакетик;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;

/**
 * Created by roman on 03.04.17.
 */
@RequiredArgsConstructor
public class ФільтрованийПотік<T> implements Потік<T> {
    private final Iterator<T> джерело;
    private final Умова<T> умова;
    private T наступнийЕлемент;

    @Override
    public boolean hasNext() {
        while (джерело.hasNext()) {
            наступнийЕлемент = джерело.next();
            if (умова.тест(наступнийЕлемент)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T next() {
        return наступнийЕлемент;
    }
}
