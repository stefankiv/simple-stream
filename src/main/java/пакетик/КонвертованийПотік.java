package пакетик;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;

/**
 * Created by roman on 03.04.17.
 */
@RequiredArgsConstructor
public class КонвертованийПотік<T, R> implements Потік<R> {

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
