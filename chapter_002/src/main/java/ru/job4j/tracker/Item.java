package ru.job4j.tracker;

import java.util.Objects;

/**
 * Package for Tracker.
 *
 * @author Dmitry Golyshkin(dmgoly@gmail.com)
 * @version $Id$
 * @since 0.1
 **/

public class Item {
    private String id;
    private String name;
    private String desc;
    private long time;

    public Item(String name,String desc){
        this.name = name;
        this.desc = desc;
    }
    public Item(String id,String name,String desc){
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public Item(String name, String decs, long time) {
        this.name = name;
        this.desc = decs;
        this.time = time;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDecs() {
        return desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return time == item.time &&
                Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(desc, item.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, time);
    }
}
