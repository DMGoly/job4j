package ru.job4j.tracker;


public class StartUI {

    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FindById = "4";
    private static final String FindByName = "5";
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI (Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit the item");
        System.out.println("3. Delete the item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find item by name");
        System.out.println("6. Exit");

    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            switch (answer) {
                case ADD:
                    this.createItem();
                    break;
                case SHOW:
                    this.showAll();
                    break;
                case EDIT:
                    this.editItem();
                    break;
                case DELETE:
                    this.deleteItem();
                    break;
                case FindById:
                    this.findById();
                    break;
                case FindByName:
                    findByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println("Такого пункта меню нет.");
            }
        }
    }
    /**
     * * Метод реализует добавленяи новый заявки в хранилище.
     * */
    private void createItem() {
        System.out.println("------------ Add new item --------------");
        String name = this.input.ask("Input number item :");
        String desc = this.input.ask("Input desc item :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ New item with getId : " + item.getId() + "-----------");
        System.out.println("------------ End of list --------------");
        }

    /**
     * Метод реализует представление всех заявок
     */

    private void showAll(){
        System.out.println("------------ Show all items --------------");
        for (Item items : this.tracker.findAll()) {
            System.out.println("Id: " + items.getId() + "\n"
                                + "Name: " + items.getName() + "\n"
                                + "Description: " + items.getDecs() + "\n");
        }
        System.out.println("------------ End of list --------------");
    }

    /**
     * Метод реализует изменение заявки
     */
    private void editItem(){
        System.out.println("------------ Edit item --------------");
        String id = this.input.ask("Enter the item Id that you want to change");
        String name = this.input.ask("Enter the item Name of the task");
        String desc = this.input.ask("Enter the item Description of the task ");
        this.tracker.replace(id,new Item(id,name,desc));
        System.out.println("------------ Editing complete --------------");
    }
    /**
     * Метод реализует удаление заявки
     */

    private void deleteItem(){
        System.out.println("------------ Delete item --------------");
        String  id = this.input.ask("Enter the item Id that you want to delete");
        this.tracker.delete(id);
        if (this.tracker.findById(id) != null){
            System.out.println("--------The item was deleted--------");
        }else{
            System.out.println("----------here is no item with tis id.------------");
        }

    }

    private  void findById(){
        System.out.println("------------ Find item by Id --------------");
        String id = this.input.ask("Enter the item Id");
        Item items = this.tracker.findById(id);
        if (this.tracker.findById(id) != null){
            System.out.println("Id: " + items.getId() + "\n"
                    + "Name: " + items.getName() + "\n"
                    + "Description: " + items.getDecs());
        }else{
            System.out.println(" There isn't item with this id. ");
        }

    }

    private void  findByName(){
        System.out.println("------------ Find item by Name --------------");
        String name = this.input.ask("Enter the tasks name :");
        Item[] items = this.tracker.findByName(name);
        if (items != null){
            for (Item item: items) {
                System.out.println("Id: " + item.getId() + "\n"
                        + "Name: " + item.getName() + "\n"
                        + "Description: " + item.getDecs());
            }
        }else{
            System.out.println("No data found with name " + name + ".");
        }
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}