package презентація.п5;

import функції.БінарнийСпоживач;
import функції.Постачальник;
import функції.Функція;

/**
 * Описує операцію скорочення, яка акумулює вхідні значення в контейнері і може додатково
 * виконати деяку операцію для перетворення вмісту контейнера в остаточне відображення результату
 */
public interface Колектор<T, A, R> {
    /**
     * Функція, яка створює новий змінний контейнер для вхідних елементів
     *
     * @return функцію, яка створює і повертає змінний контейнер
     */
    Постачальник<A> контейнер();

    /**
     * Функція, яка складає вхідні елементи в контейнер
     *
     * @return функцію, яка додає вхідні елементи в контейнер
     */
    БінарнийСпоживач<A, T> акумулятор();

    /**
     * Функція, яка перетворює вміст контейнера в остаточний результат.
     * В найпростіших випадках (коли контейнер з елементами і є остаточним результатом)
     * функція має вигляд {@code контейнер -> контейнер}
     *
     * @return функцію, яка перетворює контейнер в остаточний результат
     */
    Функція<A, R> фінішер();
}
