package презентація.п5;

import lombok.RequiredArgsConstructor;
import функції.Функція;

import java.util.Iterator;

/**
 * Ланка потоку, яка виконує функцію конвертування над кожним елементом потоку
 */
@RequiredArgsConstructor
public class КонвертованийПотік<T, R> extends АбстрактнийБазовийПотік<R> {

    private final Iterator<T> джерело;
    private final Функція<T, R> конвертер;

    @Override
    public boolean hasNext() {
        return джерело.hasNext();
    }

    @Override
    public R next() {
        return конвертер.застосувати(джерело.next());
    }
}
