package презентація.п5;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.junit.Assert.*;
import static презентація.Матчери.цеПарнеЧисло;

/**
 * Тести для потоків
 */
public class АбстрактнийБазовийПотікТест {
    private List<Integer> циферки;
    private List<String> пароліРізноїДовжини;

    @Before
    public void ініціалізіація() {
        циферки = Arrays.asList(1, 2, 3, 4, 5, 4, 3);
        пароліРізноїДовжини = Arrays.asList("1111", "мармелад", "квекве", "при чом тут Макс? 123");
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

    @Test
    public void зібратиЯкСписокТестТипу() {
        List<Integer> новийСписок = ФабрикаПотоків.потік(циферки).зібрати(Колектори.якСписок());
        assertThat(новийСписок, CoreMatchers.instanceOf(List.class));
    }

    @Test
    public void зібратиЯкСписокТестКількості() {
        List<Integer> новийСписок = ФабрикаПотоків.потік(циферки).зібрати(Колектори.якСписок());
        assertEquals(циферки.size(), новийСписок.size());
    }

    @Test
    public void зібратиЯкСетТестТипу() {
        Set<Integer> сет = ФабрикаПотоків.потік(циферки).зібрати(Колектори.якСет());
        assertThat(сет, CoreMatchers.instanceOf(Set.class));
    }

    @Test
    public void зібратиЯкСетТестКількості() {
        Set<Integer> сет = ФабрикаПотоків.потік(циферки).зібрати(Колектори.якСет());
        Set<Integer> set = циферки.stream().collect(Collectors.toSet());
        assertEquals(сет.size(), set.size());
    }

    @Test
    public void зібратиЯкМапаТестТипу() {
        Map<Integer, String> паролі = ФабрикаПотоків.потік(пароліРізноїДовжини).зібрати(Колектори.якМапа(String::length));
        assertThat(паролі, CoreMatchers.instanceOf(Map.class));
    }

    @Test
    public void зібратиЯкМапаТестМаппінга() {
        Map<Integer, String> паролі = ФабрикаПотоків.потік(пароліРізноїДовжини).зібрати(Колектори.якМапа(String::length));
        for (String пароль : пароліРізноїДовжини) {
            assertEquals(паролі.get(пароль.length()), пароль);
        }
    }
}