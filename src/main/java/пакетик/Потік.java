package пакетик;

import java.util.Iterator;

/**
 * Визначає потік елементів з можливістю послідовного виконання базових операцій над ними
 */
public interface Потік<T> extends Iterator<T> {
    /**
     * Повертає новий потік елементів, які відповідають заданій умові
     *
     * @param умова {@link Умова<T>}, яка визначає чи потрібно включати елемент до результуючого потоку
     * @return новий потік
     */
    Потік<T> фільтр(Умова<T> умова);

    /**
     * Повертає новий потік елементів, який складається з результатів виконання над кожним елементом
     * поточного потоку заданої функції
     *
     * @param конвертер {@link Функція<T, R>}, яку треба виконати над кожним елементом потоку
     * @param <R> тип результуючого потоку
     * @return новий потік
     */
    <R> Потік<R> мап(Функція<T, R> конвертер);

    /**
     * Виконує скорочення потоку, базуючись на початковому значенню і заданій асоціативній акумулюючій функції
     *
     * @param початковеЗначення початкове значення для акумулюючої фукнції
     * @param акумулятор {@link БінарнийОператор<T>}, акумулююча функція
     * @return результат скорочення потоку
     */
    T редюс(T початковеЗначення, БінарнийОператор<T> акумулятор);
}
