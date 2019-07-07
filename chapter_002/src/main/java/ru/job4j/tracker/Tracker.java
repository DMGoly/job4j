package ru.job4j.tracker;

import java.util.Calendar;
import java.util.Random;

public class Tracker {

    private Item[] items = new Item[100];
    private int position = 0;

    public Item add (Item item){
        return null;
    }
    public boolean replace(String id, Item item){
        return false;
    }
    private String generateId() {

        return String.valueOf(System.currentTimeMillis() + Math.random() * 21);
    }

}
