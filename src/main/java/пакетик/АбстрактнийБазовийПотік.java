package пакетик;

import lombok.RequiredArgsConstructor;

import java.util.Iterator;

/**
 * Created by roman on 03.04.17.
 */
@RequiredArgsConstructor
public abstract class АбстрактнийБазовийПотік<T> implements Потік<T> {
    @Override
    public Потік<T> фільтр(final Умова<T> умова) {
        return new ФільтрованийПотік<>(this, умова);
    }

    @Override
    public <R> Потік<R> мап(final Функція<T, R> конвертер) {
        return new КонвертованийПотік<>(this, конвертер);
    }

    @Override
    public T редюс(final T початковеЗначення, final БінарнийОператор<T> акумулятор) {
        T результат = початковеЗначення;
        while (this.hasNext()) {
            результат = акумулятор.застосувати(результат, this.next());
        }
        return результат;
    }
}
