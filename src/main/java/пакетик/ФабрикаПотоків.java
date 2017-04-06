package пакетик;

/**
 * Created by roman on 03.04.17.
 */
public class ФабрикаПотоків {
    public static <T> Потік<T> потік(Iterable<T> джерело) {
        return new СправжнійПотік<T>(джерело.iterator());
    }
}
