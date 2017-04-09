package презентація.п1;

import lombok.RequiredArgsConstructor;
import функції.БінарнийОператор;
import функції.Споживач;
import функції.Умова;
import функції.Функція;

import java.util.Optional;

/**
 * Базовий клас, який відповідає за побудову ланцюжків потоку
 */
@RequiredArgsConstructor
public abstract class АбстрактнийБазовийПотік<T> implements Потік<T> {
    @Override
    public void дляКожного(Споживач<T> дія) {
        // TODO: треба реалізувати
    }
}
