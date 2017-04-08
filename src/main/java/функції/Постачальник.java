package функції;

/**
 * Локалізований аналог {@link java.util.function.Supplier}
 */
@FunctionalInterface
public interface Постачальник<T> {
    /**
     * Отримує результат
     *
     * @return результат
     */
    T отримати();
}
