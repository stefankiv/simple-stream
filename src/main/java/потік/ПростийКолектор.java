package потік;

import lombok.AllArgsConstructor;
import функції.БінарнийСпоживач;
import функції.Постачальник;
import функції.Функція;

/**
 * Колектор, для якого контейнер з вхідними елементами є остаточним результатом
 */
@AllArgsConstructor
public class ПростийКолектор<T, R> implements Колектор<T, R, R> {
    private final Постачальник<R> контейнер;
    private final БінарнийСпоживач<R, T> акумулятор;

    @Override
    public Постачальник<R> контейнер() {
        return контейнер;
    }

    @Override
    public БінарнийСпоживач<R, T> акумулятор() {
        return акумулятор;
    }

    @Override
    public Функція<R, R> результат() {
        return контейнер -> контейнер;
    }
}
