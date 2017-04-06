package пакетик;

/**
 * Спеціальний випадок {@link Функція}, який виконує дію над двома вхідними елементами
 * Локалізований аналог {@link java.util.function.BinaryOperator}
 */
@FunctionalInterface
public interface БінарнийОператор<T> {
    /**
     * Застосовує поточну функцію до двох вхідних елементів
     *
     * @param першийЕлемент перший елемент функції
     * @param другийЕлемент другий елемент функції
     * @return результат виконання функції
     */
    T застосувати(T першийЕлемент, T другийЕлемент);
}
