package org.example;
import org.example.Animals.Animals;
public class AnimalMapper {
    public String map(Animals animal) {
        return String.format("%s; %s; %s", animal.getId(), animal.getName(), animal.getSound());
    }


    public Animals map(String line) {
        if (line.contains("; ")) {
            String[] lines = line.split("; ");
            return new Animals(lines[0], lines[1], lines[2]);
        } else {
            String[] lines = line.split(",");
            return new Animals(lines[0], lines[1], lines[2]);
        }
    }
}