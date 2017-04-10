package презентація.п5;

import lombok.AllArgsConstructor;
import функції.Споживач;

/**
 * Термінальний оператор, який виконує задану дію над кожним елементом потоку
 */
@AllArgsConstructor
public class ДляКожногоОператор<T> implements ТермінальнийОператор<Void> {
    private final Потік<T> потік;
    private final Споживач<T> дія;

    @Override
    public Void закінчити() {
        while (потік.hasNext()) {
            дія.прийняти(потік.next());
        }
        return null;
    }
}
