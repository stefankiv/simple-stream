package презентація.п3;

import функції.Споживач;
import функції.Умова;
import функції.Функція;


/**
 * Базовий клас, який відповідає за побудову ланцюжків потоку
 */
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
    public void дляКожного(Споживач<T> дія) {
        while (hasNext()) {
            дія.прийняти(next());
        }
    }
}
