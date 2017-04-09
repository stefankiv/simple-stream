package потік;

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
        return потік.hasNext() ? Optional.ofNullable(потік.next()) : Optional.empty();
    }
}
