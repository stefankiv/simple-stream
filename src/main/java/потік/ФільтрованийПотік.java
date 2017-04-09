package потік;

import lombok.RequiredArgsConstructor;
import функції.Умова;

import java.util.Iterator;

/**
 * Ланка потоку, яка перевіряє кожен елемент потоку на відповідність заданій умові
 * і повертає елемент тільки якщо той проходить перевірку
 */
@RequiredArgsConstructor
public class ФільтрованийПотік<T> extends АбстрактнийБазовийПотік<T> {

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
