package потік;

/**
 * Допоміжний клас, який дозволяє створювати потоки
 */
public class ФабрикаПотоків {
    /**
     * Створює потік елементів із заданого джерела
     *
     * @param джерело джерело елементів, яке потрібно перетворити у потік
     * @param <T> тип елементу потоку
     * @return новий потік елементів
     */
    public static <T> Потік<T> потік(Iterable<T> джерело) {
        return new Джерело<T>(джерело.iterator());
    }
}
