package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    PrintStream stdout = System.out;
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
    }

    private final static String menu = "Меню.\n"
            + "0. Add new item\n"
            + "1. Show all items\n"
            + "2. Edit the item\n"
            + "3. Delete the item\n"
            + "4. Find item by Id\n"
            + "5. Find item by name\n"
            + "6. Exit";

    Tracker tracker = new Tracker();

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StabInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StabInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDelete() {
        Item item = tracker.add(new Item("test", "desc"));
        Item item1 = tracker.add(new Item("test2", "desc2"));
        Input input = new StabInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test2"));
    }

    @Test
    public void whenFindAll() {
        Item item = tracker.add(new Item("test", "desc"));
        Input input = new StabInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                this.out.toString(),
                is((menu + "\n" +
                        "------------ Show all items --------------\n"
                        + "Id: " + item.getId() + "\n"
                        + "Name: " + item.getName() + "\n"
                        + "Description: " + item.getDecs() + "\n\n"
                        + "------------ End of list --------------\n"

                        + menu) +
                        System.lineSeparator())
        );
    }

    @Test
    public void whenFindById() {
        Item item = tracker.add(new Item("test", "desc"));
        Input input = new StabInput(new String[]{"4",item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                this.out.toString(),
                is((menu + "\n" +
                        "------------ Find item by Id --------------\n"
                        + "Id: " + item.getId() + "\n"
                        + "Name: " + item.getName() + "\n"
                        + "Description: " + item.getDecs() + "\n"
                        + menu) +
                        System.lineSeparator())
        );
    }
    @Test
    public void whenFindByName() {
        Item item = tracker.add(new Item("test", "desc"));
        Input input = new StabInput(new String[]{"5",item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                this.out.toString(),
                is((menu + "\n" +
                        "------------ Find item by Name --------------\n"
                        + "Id: " + item.getId() + "\n"
                        + "Name: " + item.getName() + "\n"
                        + "Description: " + item.getDecs() + "\n"
                        + menu) +
                        System.lineSeparator())
        );
    }

}


