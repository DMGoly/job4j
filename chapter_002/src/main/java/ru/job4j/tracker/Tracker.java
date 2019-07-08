package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Random;

public class Tracker {

    private Item[] items = new Item[100];
    private int position = 0;

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */

    private String generateId() {

         return String.valueOf(System.currentTimeMillis() + Math.random() * 21);
    }


    public Item add (Item item){
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }
    /**
     * Метод, заменяющий ячейку в массиве this.items.
     *
     * @param id   id ячейки в массиве, которую нужно заменить.
     * @param item объект на который нужно заменить
     * @return true если успешно, иначе false.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.position; i++) {
            if (this.items != null && this.items[i].getId().equals(id)) {
                this.items[i] = item;
                this.items[i].setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод, удаляющий ячейку в массиве и смещающий все элементы после него на 1 ячейку влево.
     *
     * @param id массива, который нужно удалить.
     * @return true если успешно, иначе false.
     */

    public boolean delete(String id){
        boolean result = false;
        for (int count = 0; count < this.position; count++) {
            if (this.items != null && this.items[count].getId().equals(id)) {
                System.arraycopy(this.items, count + 1, this.items, count, this.position - count - 1);
                this.items[this.position - 1] = null;
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll(){
        return Arrays.copyOf(items, position);
    }

    public Item[] findByName(String key){
        Item[] result = new Item[items.length];
        int count = 0;
        for (int i = 0; i < items.length; i++){
            if (items[i].getName().equals(key)){
            result[count] = items[i];
            count++;
            }
        }
        return Arrays.copyOf(result,count);
    }

    public Item findById(String id){
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)){
                result = item;
                break;
            }
        }
        return result;
    }



}