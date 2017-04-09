package презентація.п2;

import функції.Споживач;
import функції.Функція;

/**
 * Базовий клас, який відповідає за побудову ланцюжків потоку
 */
public abstract class АбстрактнийБазовийПотік<T> implements Потік<T> {
    @Override
    public <R> Потік<R> мап(final Функція<T, R> конвертер) {
        // TODO: треба реалізувати
        return null;
    }

    @Override
    public void дляКожного(Споживач<T> дія) {
        while (hasNext()) {
            дія.прийняти(next());
        }
    }
}
