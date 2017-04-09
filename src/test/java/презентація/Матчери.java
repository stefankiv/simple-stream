package презентація;

import org.hamcrest.CustomTypeSafeMatcher;

/**
 * Матчери, які використовуються для тестування
 */
public class Матчери {
    /**
     * Повертає матчер, який провіряє чи число є парним.
     *
     * @return матчер парних чисел
     */
    public static CustomTypeSafeMatcher<Integer> цеПарнеЧисло() {
        return new CustomTypeSafeMatcher<Integer>("Перевіряє чи число є парним.") {
            @Override
            protected boolean matchesSafely(Integer item) {
                return item % 2 == 0;
            }
        };
    }
}
