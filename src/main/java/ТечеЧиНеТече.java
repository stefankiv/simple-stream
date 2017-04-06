import потік.ФабрикаПотоків;

import java.util.Arrays;

/**
 * Created by roman on 03.04.17.
 */
public class ТечеЧиНеТече {
    public static void main(String[] args) {
        final String парніСтрічки = ФабрикаПотоків.потік(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
                .фільтр(e -> e % 2 == 0)
                .мап(e -> "\nтепер це стрічка: " + e)
                .редюс("Усе разом: ", String::concat);
        System.out.println(парніСтрічки);
    }
}
