package потік;

import lombok.AllArgsConstructor;
import функції.БінарнийОператор;

/**
 * Термінальний оператор, який виконує скорочення потоку на основі
 * заданого початкового значення і акумулятивної функції.
 */
@AllArgsConstructor
public class РедюсОператор<T> implements ТермінальнийОператор<T> {
    private final Потік<T> потік;
    private final T початковеЗначення;
    private final БінарнийОператор<T> акумулятор;

    @Override
    public T закінчити() {
        T результат = початковеЗначення;
        while (потік.hasNext()) {
            результат = акумулятор.застосувати(результат, потік.next());
        }
        return результат;
    }
}
