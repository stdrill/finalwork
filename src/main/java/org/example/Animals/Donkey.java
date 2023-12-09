package org.example.Animals;

public class Donkey extends PackAnimals implements Sayable{
    public Donkey(String id, String name, String sound) {
        super(id, name, sound);
    }

    @Override
    public String say() {
        return "iaa";
    }
}
