package me.wondertwo.ctci145;

import java.util.LinkedList;

/**
 *
 * Created by Allenieo on 2016/4/29.
 */
public class AnimalQueue {

    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }

    private Dog dequeueDogs() {
        return dogs.poll();
    }

    private Cat dequeueCats() {
        return cats.poll();
    }

    public Animal dequeueAny() {
        if (dogs.size() == 0) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }
}
