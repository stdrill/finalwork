package org.example.Animals;

public class Dogs extends HomeAnimals implements Sayable{
    public Dogs(String id, String name, String sound) {
        super(id, name, sound);
    }

    @Override
    public String say() {
        return "gav";
    }
}
