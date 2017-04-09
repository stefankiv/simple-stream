package презентація.п3;

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
        // TODO: треба реалізувати
        return false;
    }

    @Override
    public T next() {
        // TODO: треба реалізувати
        return null;
    }
}
