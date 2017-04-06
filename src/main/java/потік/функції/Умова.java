package потік.функції;

/**
 * Локалізований аналог {@link java.util.function.Predicate}
 */
@FunctionalInterface
public interface Умова<T> {
    /**
     * Визначає чи заданий елемент проходить перевірку
     *
     * @param елемент елемент, який потрібно перевірити
     * @return {@literal true}, якщо вхідний елемент проходить перевірку, {@literal false} якщо ні
     */
    boolean тест(T елемент);
}
