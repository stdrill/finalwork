package org.example.Animals;

public class Camels extends PackAnimals implements Sayable{
    public Camels(String id, String name, String sound) {
        super(id, name, sound);
    }

    @Override
    public String say() {
        return "grrr";
    }
}
