package org.example.Animals;

public class Cats extends HomeAnimals implements Sayable{
    public Cats(String id, String name, String sound) {
        super(id, name, sound);
    }

    @Override
    public String say() {
        return "meow";
    }
}
