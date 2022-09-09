package ru.gb.level3;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {

    private final List<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public List<T> takeAllFruits() {
        List<T> takenFruits = new ArrayList<>(fruits);
        fruits.clear();
        return takenFruits;
    }

    public float getWeight() {
        float weight = 0f;
        for (Fruit fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> box) {
        return getWeight() == box.getWeight();
    }

    public void takeAllFrom(Box<T> box) {
        fruits.addAll(box.takeAllFruits());
    }
}
