package функції;

/**
 * Локалізований аналог {@link java.util.function.Function}
 */
@FunctionalInterface
public interface Функція<T, R> {
    /**
     * Застовосує поточну функцію до даного елементу
     *
     * @param елемент елемент, над яким треба виконати операцію
     * @return результат виконання функції
     */
    R застосувати(T елемент);
}
