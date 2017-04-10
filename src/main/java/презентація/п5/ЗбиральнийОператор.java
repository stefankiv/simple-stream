package презентація.п5;

import lombok.AllArgsConstructor;
import функції.БінарнийСпоживач;

/**
 * Термінальний оператор, який виконує спорочення потоку на основі вказаного колектора
 */
@AllArgsConstructor
public class ЗбиральнийОператор<T, A, R> implements ТермінальнийОператор<R> {
    private final Потік<T> потік;
    private final Колектор<T, A, R> колектор;

    @Override
    public R закінчити() {
        // TODO: треба реалізувати
        return null;
    }
}
