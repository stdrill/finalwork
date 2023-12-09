package org.example.Animals;

public class Animals implements Sayable{
    private String id;
    private String name;
    private String sound;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public Animals(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public Animals(String id, String name, String sound) {
        this(name, sound);
        this.id = id;
    }

    @Override
    public String toString() {
        return "id: " + id + ", name: " + name + ", sound: " + sound;
    }


    @Override
    public String say() {
        return null;
    }
}
