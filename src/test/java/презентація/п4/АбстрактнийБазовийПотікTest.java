package презентація.п4;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.junit.Assert.*;
import static презентація.Матчери.цеПарнеЧисло;

/**
 * Тести для потоків
 */
public class АбстрактнийБазовийПотікTest {
    private List<Integer> циферки;

    @Before
    public void ініціалізіація() {
        циферки = Arrays.asList(1, 2, 3, 4, 5);
    }

    @Test
    public void дляКожногоТест() {
        List<Integer> новийСписок = new ArrayList<>();
        ФабрикаПотоків.потік(циферки).дляКожного(новийСписок::add);
        assertEquals(циферки.size(), новийСписок.size());
        System.out.println(новийСписок);
    }

    @Test
    public void мапТест() {
        List<String> стрічки = new ArrayList<>();

        ФабрикаПотоків.потік(циферки)
                .мап(String::valueOf)
                .мап("Стрічка "::concat)
                .дляКожного(стрічки::add);

        assertEquals(циферки.size(), стрічки.size());
        ФабрикаПотоків.потік(стрічки).дляКожного(System.out::println);
    }

    @Test
    public void фільтрТест() {
        List<Integer> парніЧисла = new ArrayList<>();

        ФабрикаПотоків.потік(циферки)
                .фільтр(число -> число % 2 == 0)
                .дляКожного(парніЧисла::add);

        assertTrue(!парніЧисла.isEmpty());
        assertThat(парніЧисла, everyItem(цеПарнеЧисло()));

        System.out.print("Вхідні елементи: ");
        System.out.println(циферки);
        System.out.print("Відфільтровані (лише парні): ");
        System.out.println(парніЧисла);
    }

    @Test
    public void редюс() {
        Integer сума = ФабрикаПотоків.потік(циферки).редюс(0, Integer::sum);
        Integer sum = циферки.stream().reduce(0, Integer::sum);
        assertEquals(сума, sum);
        System.out.printf("%s = %s", сума, sum);
    }
}