package презентація.п2;

import org.junit.Before;
import org.junit.Test;
import презентація.модель.Телефон;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Тести для потоків
 */
public class АбстрактнийБазовийПотікТест {
    private List<Integer> циферки;

    @Before
    public void ініціалізіація() {
        циферки = Arrays.asList(1, 2, 3, 4, 5);
    }

    @Test
    public void дляКожногоТест() {
        List<Integer> новийСписок = new ArrayList<>();
        ФабрикаПотоків.потік(циферки).дляКожного(новийСписок::add);
        assertEquals("Розмір нового списку має бути таким, як і джерела", циферки.size(), новийСписок.size());
        System.out.println(новийСписок);
    }

    @Test
    public void мапТест() {
        List<Телефон> телефони = new ArrayList<>();

        ФабрикаПотоків.потік(циферки)
                .мап(число -> new Телефон("Телефон " + число, число + 1))
                .дляКожного(телефони::add);

        assertEquals(циферки.size(), телефони.size());
        ФабрикаПотоків.потік(телефони).дляКожного(System.out::println);
    }
}