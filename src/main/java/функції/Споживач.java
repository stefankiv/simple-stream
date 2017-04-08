package функції;

/**
 * Локалізований аналог {@link java.util.function.Consumer}
 */
@FunctionalInterface
public interface Споживач<T> {
    /**
     * Виконує цю операцію над даним елементом
     *
     * @param елемент вхідний елемент
     */
    void прийняти(T елемент);
}
