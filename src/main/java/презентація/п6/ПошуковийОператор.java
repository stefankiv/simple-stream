package презентація.п6;

import lombok.AllArgsConstructor;

import java.util.Optional;

/**
 * {@code short-circuit} термінальний оператор, який шукає елементи в потоці.
 * Припиняє пошук, коли знайде <b>перший</b> елемент.
 */
@AllArgsConstructor
public class ПошуковийОператор<T> implements ТермінальнийОператор<Optional<T>> {
    private final Потік<T> потік;

    @Override
    public Optional<T> закінчити() {
        // TODO: треба реалізувати
        return null;
    }
}
