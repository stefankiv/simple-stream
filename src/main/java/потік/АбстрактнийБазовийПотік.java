package потік;

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
    public Потік<T> фільтр(final Умова<T> умова) {
        return new ФільтрованийПотік<>(this, умова);
    }

    @Override
    public <R> Потік<R> мап(final Функція<T, R> конвертер) {
        return new КонвертованийПотік<>(this, конвертер);
    }

    @Override
    public T редюс(final T початковеЗначення, final БінарнийОператор<T> акумулятор) {
        return закінчитиПотік(new РедюсОператор<>(this, початковеЗначення, акумулятор));
    }

    @Override
    public void дляКожного(Споживач<T> дія) {
        закінчитиПотік(new ДляКожногоОператор<>(this, дія));
    }

    @Override
    public <R, A> R зібрати(Колектор<T, A, R> колектор) {
        return закінчитиПотік(new ЗбиральнийОператор<>(this, колектор));
    }

    @Override
    public Optional<T> знайтиПерший() {
        return закінчитиПотік(new ПошуковийОператор<>(this));
    }

    /**
     * Закінчує потік, виконуючи дану термінальну операцію
     *
     * @param термінальнийОператор термінальна операція, яка виконує потік і підраховує результат його виконання
     * @param <R> тип результуючого значення
     * @return результат виконання потоку
     */
    private <R> R закінчитиПотік(ТермінальнийОператор<R> термінальнийОператор) {
        return термінальнийОператор.закінчити();
    }
}
