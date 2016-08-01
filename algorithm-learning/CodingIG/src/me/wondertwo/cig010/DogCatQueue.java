package me.wondertwo.cig010;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wondertwo on 2016/7/29.
 */
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getTypee().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, count++));
        } else if (pet.getTypee().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("error, not cat or dog");
        }
    }

    public Pet pollAll() {
        if (!this.catQ.isEmpty() && !this.dogQ.isEmpty()) {
            if (this.catQ.peek().getCount() < this.dogQ.peek().getCount()) {
                return this.catQ.poll().getPet();
            } else {
                return this.dogQ.poll().getPet();
            }
        } else if (! this.catQ.isEmpty()) {
            return  this.catQ.poll().getPet();
        } else if (! this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("error, queue is empty");
        }
    }

    public Cat pollCat() {
        if (! this.catQ.isEmpty()) {
            return (Cat) this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("error, cat queue is empty");
        }
    }

    public Dog pollDog() {
        if (! this.dogQ.isEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("error, dog queue is empty");
        }
    }

    public boolean isEmpty() {
        return this.catQ.isEmpty() && this.dogQ.isEmpty();
    }

    public boolean isDogEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatEmpty() {
        return this.catQ.isEmpty();
    }
}
