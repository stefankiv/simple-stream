package пакетик;

import java.util.Iterator;

/**
 * Created by roman on 03.04.17.
 */
public interface Потік<T> extends Iterator<T> {
    default Потік<T> фільтр(Умова<T> умова) {
        return new ФільтрованийПотік<>(this, умова);
    }

    default <R> Потік<R> мап(Функція<T, R> конвертер) {
        return new КонвертованийПотік<>(this, конвертер);
    }

    // todo придумати нормальний переклад
    default T редюс(T початковеЗначення, БінарнийОператор<T> акумулятор) {
        T результат = початковеЗначення;
        while (this.hasNext()) {
            результат = акумулятор.застосувати(результат, this.next());
        }
        return результат;
    }
}
