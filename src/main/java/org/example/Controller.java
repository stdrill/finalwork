package org.example;
import org.example.Animals.Animals;

import java.util.List;
public class Controller {
    private final ReposInterface repos_Interface;

    public Controller(ReposInterface repos_Interface) {
        this.repos_Interface = repos_Interface;
    }

    public void saveAnimal(Animals animal) throws Exception {
        repos_Interface.CreateAnimal(animal);
    }

    public void saveCommands(List commands) throws Exception{
        repos_Interface.createCommand(commands);
    }



    public Animals readAnimal(String animalId) throws Exception {
        List<Animals> animals = repos_Interface.getAllAnimals();
        for (Animals animal : animals) {
            if (animal.getId().equals(animalId)) {
                return animal;
            }
        }
        throw new Exception("Animal not found. Try another choice.");
    }

    public void deleteAnimal(String animalId) throws Exception { // удаление из списка игрушек
        List<Animals> animals = repos_Interface.getAllAnimals();
        System.out.println("Работает контроллер: запись удаляется из списка...");
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getId().equals(animalId)) {
                animals.remove(animals.get(i));
                repos_Interface.deleteAnimal(animals); // вызываем интрефейс репозиторий
            }
        }
    }

    public List<Animals> getAnimals() throws Exception {
        return repos_Interface.getAllAnimals();
    }
    public List  getCommands() throws Exception {
        return repos_Interface.getAllCommands();
    }

}
