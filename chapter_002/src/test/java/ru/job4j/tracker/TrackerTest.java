package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    Tracker tracker = new Tracker();
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Item previous = new Item("test1","testDescription",123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2","testDescription2",1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenDeleteItemThenReturnNewItems(){
        Item previous = new Item("test1","testDescription",123L);
        Item previous1 = new Item("test2","testDescription2",321L);
        tracker.add(previous);
        tracker.add(previous1);
        assertThat(tracker.delete(previous.getId()),is(true));
    }

    @Test
    public void whenFindAll(){
        Item previous = new Item("test1","testDescription",123L);
        Item previous1 = new Item("test2","testDescription2",321L);
        tracker.add(previous);
        tracker.add(previous1);
        Item[] array = new Item[]{previous,previous1};
        assertThat(tracker.findAll(),is(array));
    }

    @Test
    public void whenFindId(){
        Item previous = new Item("test1","testDescription",123L);
        Item previous1 = new Item("test2","testDescription2",321L);
        tracker.add(previous);
        tracker.add(previous1);
        assertThat(tracker.findById(previous.getId()),is(previous));
    }

    @Test
    public void whenFindName(){
        Item previous = new Item("test1","testDescription",123L);
        Item previous1 = new Item("test2","testDescription2",321L);
        tracker.add(previous);
        tracker.add(previous1);
        assertThat(tracker.findById(previous.getId()).getName(),is("test1"));
    }

}
