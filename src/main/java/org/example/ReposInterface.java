package org.example;
import org.example.Animals.Animals;

import java.util.List;

public interface ReposInterface {
    List<Animals> getAllAnimals();
    List  getAllCommands();
    void CreateAnimal(Animals animal);
    void createCommand(List commands);
    void deleteAnimal(List animals);

}
