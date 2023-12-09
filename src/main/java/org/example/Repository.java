package org.example;
import org.example.Animals.Animals;
import java.util.ArrayList;
import java.util.List;

public class Repository implements ReposInterface{
    private final AnimalMapper mapper = new AnimalMapper();
    private final FileOperation fileOperation;

    public Repository(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }

    @Override
    public List<Animals> getAllAnimals() {
        List<String> lines = fileOperation.readAllLines();
        List<Animals> listAnimals = new ArrayList<>();
        for (String line : lines) {
            listAnimals.add(mapper.map(line));
        }
        return listAnimals;
    }


    public List  getAllCommands() {

        return fileOperation.readCommand();
    }




    @Override
    public void CreateAnimal(Animals animal) {
        List<Animals> listAnimals = getAllAnimals();
        int max = 0;
        for (Animals item : listAnimals) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        animal.setId(id);
        listAnimals.add(animal);
        List<String> lines = new ArrayList<>();
        for (Animals item : listAnimals) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }

    public void createCommand(List commands){
        fileOperation.saveCommand(commands);
    }



    @Override
    public void deleteAnimal(List animals) {
        List<String> lines = new ArrayList<>();
        List<Animals> delAnimals = animals;
        System.out.println("Работает репозиторий:  маппер создает новыe lines для записи...");
        for (Animals item : delAnimals) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
        System.out.println("Удаление завершено успешно!");
    }
}
