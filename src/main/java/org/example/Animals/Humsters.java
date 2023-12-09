package org.example.Animals;

public class Humsters extends HomeAnimals implements Sayable{
    public Humsters(String id, String name, String sound) {
        super(id, name, sound);
    }

    @Override
    public String say() {
        return "chiu";
    }
}
